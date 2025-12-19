package com.example.SantaWishlist.dto;

import com.example.SantaWishlist.model.BehaviorStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record GiftWishRequest(
        @NotBlank(message = "Имя ребенка не должно быть пустым")
        String childName,

        @NotBlank(message = "Название подарка обязательно")
        String giftName,

        @Min(1) @Max(10)
        Integer priority,

        BehaviorStatus status
) {}