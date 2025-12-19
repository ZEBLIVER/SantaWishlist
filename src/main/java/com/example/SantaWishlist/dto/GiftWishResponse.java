package com.example.SantaWishlist.dto;

import com.example.SantaWishlist.model.BehaviorStatus;

import java.time.LocalDateTime;

public record GiftWishResponse(
        Long id,
        String childName,
        String giftName,
        Integer priority,
        BehaviorStatus status,
        LocalDateTime createdAt
) {}
