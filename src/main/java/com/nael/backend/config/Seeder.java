package com.nael.backend.config;

import com.nael.backend.Dto.cart.AddToCartDto;
import com.nael.backend.Dto.cart.CartDto;
import com.nael.backend.Dto.cart.CartItemDto;
import com.nael.backend.controller.CartController;
import com.nael.backend.entity.*;
import com.nael.backend.repository.*;
import com.nael.backend.service.CartServices;
import com.nael.backend.service.CustomerService;
import com.nael.backend.service.OrderService;
import com.nael.backend.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class Seeder {
    @Bean
    CommandLineRunner commandLineRunner(
            ProductRepository productRepository,
            ProductService productService,
            CustomerRepository customerRepository,
            CustomerService customerService,
            OrderRepository orderRepository,
            OrderService orderService,
            CartRepository cartRepository,
            CartServices cartServices,
            CartController cartController
    ) {
        return args -> {
            List<Customer> customers = List.of(
                    new Customer("Nael", "123456789"),
                    new Customer("Ahmed", "123456789"),
                    new Customer("Mohamed", "123456789"),
                    new Customer("Ali", "123456789"),
                    new Customer("Khaled", "123456789"),
                    new Customer("Hassan", "123456789"),
                    new Customer("Mahmoud", "123456789"),
                    new Customer("Omar", "123456789"),
                    new Customer("Amr", "123456789"),
                    new Customer("Youssef", "123456789"),
                    new Customer("Hussein", "123456789")
            );
            customerRepository.saveAll(customers);

            List<Product> products = List.of(
                    new Product("Product 1", 100),
                    new Product("Product 2", 200),
                    new Product("Product 3", 300),
                    new Product("Product 4", 400),
                    new Product("Product 5", 500),
                    new Product("Product 6", 600),
                    new Product("Product 7", 700),
                    new Product("Product 8", 800),
                    new Product("Product 9", 900),
                    new Product("Product 10", 1000),
                    new Product("Product 11", 1100)
            );
            productRepository.saveAll(products);

            List<Cart> carts = List.of(
                    new Cart(products.get(0), customers.get(0), 10),
                    new Cart(products.get(1), customers.get(0), 10),
                    new Cart(products.get(2), customers.get(0), 10),
                    new Cart(products.get(3), customers.get(0), 10),
                    new Cart(products.get(4), customers.get(0), 10)
            );
            cartRepository.saveAll(carts);


            CartDto cartDto = new CartDto(
                    List.of(
                            new CartItemDto(10, products.get(0)),
                            new CartItemDto(10, products.get(1)),
                            new CartItemDto(10, products.get(2)),
                            new CartItemDto(10, products.get(3))
                    ),
                    customers.get(1).getId()
            );

            cartController.addToCart(cartDto);

            orderService.placeOrder(customers.get(0));
            orderService.placeOrder(customers.get(1));

        };
    }


}
