package com.example.SantaWishlist.exception;


public class GiftNotFoundException extends RuntimeException {

    public GiftNotFoundException(Long id) {
        super("Подарок с ID " + id + " не найден в списке Санты!");
    }
}
