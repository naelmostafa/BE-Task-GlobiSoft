package com.nael.backend.Dto.cart;

import java.util.List;

public class CartDto {
    List<CartItemDto> cartItems;
    private Integer customerId;
    private double totalCost;

    public CartDto(List<CartItemDto> cartItems, double totalCost) {
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }

    public CartDto(List<CartItemDto> cartItems, Integer customerId, double totalCost) {
        this.cartItems = cartItems;
        this.customerId = customerId;
        this.totalCost = totalCost;
    }

    public CartDto(List<CartItemDto> cartItems, Integer customerId) {
        this.cartItems = cartItems;
        this.customerId = customerId;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
