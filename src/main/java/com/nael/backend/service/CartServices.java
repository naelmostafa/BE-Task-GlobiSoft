package com.nael.backend.service;

import com.nael.backend.Dto.cart.AddToCartDto;
import com.nael.backend.Dto.cart.CartDto;
import com.nael.backend.Dto.cart.CartItemDto;
import com.nael.backend.entity.Cart;
import com.nael.backend.entity.Customer;
import com.nael.backend.entity.Product;
import com.nael.backend.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServices {

    private final CartRepository cartRepository;

    @Autowired
    public CartServices(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(AddToCartDto addToCartDto, Product product, Customer customer) {
        Cart cart = new Cart(
                product,
                customer,
                addToCartDto.getQuantity()
        );
        return cartRepository.save(cart);
    }

    public Cart updateCart(AddToCartDto addToCartDto, Product product, Customer customer) {
        Cart cart = cartRepository.findById(addToCartDto.getId()).orElse(null);
        if (cart == null) throw new AssertionError();
        cart.setQuantity(addToCartDto.getQuantity());
        return cartRepository.save(cart);
    }

    public CartDto listCartItems(Customer customer) {
        List<Cart> cartList = cartRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart : cartList) {
            CartItemDto cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDto cartItemDto : cartItems) {
            totalCost += (cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity());
        }
        return new CartDto(cartItems, totalCost);
    }

    public static CartItemDto getDtoFromCart(Cart cart) {
        return new CartItemDto(cart);
    }

    public void deleteCartItems(Integer customerId) {
        cartRepository.deleteAll();
    }

    @Transactional
    public void deleteUserCartItems(Customer customer) {
        cartRepository.deleteByCustomer(customer);
    }

}
