package com.example.SantaWishlist.config;

import com.example.SantaWishlist.model.BehaviorStatus;
import com.example.SantaWishlist.model.GiftWish;
import com.example.SantaWishlist.repository.GiftWishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final GiftWishRepository giftWishRepository;

    @Override
    public void run(String... args) {
        if (giftWishRepository.count() == 0) {
            giftWishRepository.saveAll(List.of(
                    new GiftWish(null, "Гриша", "Менторство у JAVA DADDY", 10, BehaviorStatus.GOOD, null),
                    new GiftWish(null, "Никита", "Набор для покера", 5, BehaviorStatus.BAD, null),
                    new GiftWish(null, "Маша", "Спиннер", 9, BehaviorStatus.GOOD, null),
                    new GiftWish(null, "Миша", "Игровой компьютер", 7, BehaviorStatus.GOOD, null),
                    new GiftWish(null, "Саша", "Чизкейк", 1, BehaviorStatus.NEUTRAL, null)
            ));
            log.info("В бд успешно добавлены начальные данные.");
        } else {
            log.info("База уже заполнена начальными данными. Пропускаем.");
        }
    }

}