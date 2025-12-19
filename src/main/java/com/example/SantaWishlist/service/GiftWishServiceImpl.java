package com.example.SantaWishlist.service;

import com.example.SantaWishlist.dto.GiftWishRequest;
import com.example.SantaWishlist.dto.GiftWishResponse;
import com.example.SantaWishlist.exception.GiftNotFoundException;
import com.example.SantaWishlist.model.GiftWish;
import com.example.SantaWishlist.repository.GiftWishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftWishServiceImpl implements GiftWishService {

    private final GiftWishRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<GiftWishResponse> getAllWishes(Sort sort) {
        return repository.findAll(sort).stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public GiftWishResponse createWish(GiftWishRequest request) {
        GiftWish wish = GiftWish.builder()
                .childName(request.childName())
                .giftName(request.giftName())
                .priority(request.priority())
                .behaviorStatus(request.status())
                .build();

        GiftWish savedWish = repository.save(wish);
        return mapToResponse(savedWish);
    }

    @Override
    @Transactional(readOnly = true)
    public GiftWishResponse getWishById(Long id) {
        GiftWish wish = repository.findById(id)
                .orElseThrow(() -> new GiftNotFoundException(id));
        return mapToResponse(wish);
    }

    private GiftWishResponse mapToResponse(GiftWish wish) {
        return new GiftWishResponse(
                wish.getId(),
                wish.getChildName(),
                wish.getGiftName(),
                wish.getPriority(),
                wish.getBehaviorStatus(),
                wish.getCreatedAt()
        );
    }
}
