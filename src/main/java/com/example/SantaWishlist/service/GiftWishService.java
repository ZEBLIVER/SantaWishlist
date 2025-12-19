package com.example.SantaWishlist.service;

import com.example.SantaWishlist.dto.GiftWishRequest;
import com.example.SantaWishlist.dto.GiftWishResponse;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GiftWishService {
    List<GiftWishResponse> getAllWishes(Sort sort);
    GiftWishResponse createWish(GiftWishRequest request);
    GiftWishResponse getWishById(Long id);
}