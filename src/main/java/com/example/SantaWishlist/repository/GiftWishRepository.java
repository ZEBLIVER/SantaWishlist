package com.example.SantaWishlist.repository;

import com.example.SantaWishlist.model.GiftWish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftWishRepository extends JpaRepository<GiftWish, Long> {
}
