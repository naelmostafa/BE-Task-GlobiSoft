package com.nael.backend.controller;

import com.nael.backend.entity.Customer;
import com.nael.backend.entity.Order;
import com.nael.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/{add}")
    public Order addOrder(@RequestBody Customer Customer) {
        return orderService.placeOrder(Customer);
    }

    @PostMapping("/place-order/{customer}")
    public Order placeOrder(@RequestBody Customer Customer) {
        return orderService.placeOrder(Customer);
    }
}
