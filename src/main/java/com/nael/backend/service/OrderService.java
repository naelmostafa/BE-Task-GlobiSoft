package com.nael.backend.service;

import com.nael.backend.Dto.cart.CartDto;
import com.nael.backend.Dto.cart.CartItemDto;
import com.nael.backend.entity.Customer;
import com.nael.backend.entity.Order;
import com.nael.backend.entity.OrderItem;
import com.nael.backend.repository.OrderItemRepository;
import com.nael.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartServices cartServices;

    private final OrderItemRepository orderItemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CartServices cartServices, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.cartServices = cartServices;
        this.orderItemRepository = orderItemRepository;
    }

    public Order placeOrder(Customer customer) {
        CartDto cartDto = cartServices.listCartItems(customer);

        List<CartItemDto> cartItems = cartDto.getCartItems();

        Order order = new Order();
        order.setCustomer(customer);
        order.setTotalPrice(cartDto.getTotalCost());
        order.setTotalPrice(cartDto.getTotalCost());
        orderRepository.save(order);

        for (CartItemDto cartItemDto : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItemDto.getProduct());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setPrice(cartItemDto.getProduct().getPrice());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }

        cartServices.deleteUserCartItems(customer);

        return order;
    }

    public List<Order> listOrders(Customer customer) {
        return orderRepository.findAllByCustomerOrderByCreatedDateDesc(customer);
    }

}
