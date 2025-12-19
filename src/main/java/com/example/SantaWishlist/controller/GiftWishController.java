package com.example.SantaWishlist.controller;

import com.example.SantaWishlist.dto.GiftWishRequest;
import com.example.SantaWishlist.dto.GiftWishResponse;
import com.example.SantaWishlist.service.GiftWishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishes")
@RequiredArgsConstructor
public class GiftWishController {

    private final GiftWishService giftWishService;

    @GetMapping
    public List<GiftWishResponse> getAll(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction) {

        return giftWishService.getAllWishes(Sort.by(direction, sortBy));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GiftWishResponse create(@Valid @RequestBody GiftWishRequest request) {
        return giftWishService.createWish(request);
    }

    @GetMapping("/{id}")
    public GiftWishResponse getById(@PathVariable Long id) {
        return giftWishService.getWishById(id);
    }
}
