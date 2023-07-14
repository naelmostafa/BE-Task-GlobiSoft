package com.nael.backend.controller;


import com.nael.backend.Dto.cart.AddToCartDto;
import com.nael.backend.Dto.cart.CartDto;
import com.nael.backend.entity.Cart;
import com.nael.backend.entity.Customer;
import com.nael.backend.entity.Product;
import com.nael.backend.service.CartServices;
import com.nael.backend.service.CustomerService;
import com.nael.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    private final CartServices cartServices;
    private final ProductService productService;
    private final CustomerService customerService;

    @Autowired
    public CartController(CartServices cartServices, ProductService productService, CustomerService customerService) {
        this.cartServices = cartServices;
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public Iterable<Cart> getAllCarts() {
        return cartServices.getAllCarts();
    }

    @PostMapping("/{add}")
    public Iterable<Cart> addToCart(@RequestBody CartDto cartDto) {
        Customer customer = this.customerService.getCustomerById(cartDto.getCustomerId());
        return cartServices.addItemsToCart(cartDto.getCartItems(), customer);
    }

    @PutMapping("/{update}")
    public Cart updateCart(@RequestBody AddToCartDto addToCartDto) {
        Customer customer = this.customerService.getCustomerById(addToCartDto.getCustomerId());
        Product product = this.productService.getProductById(addToCartDto.getProductId());
        return cartServices.updateCart(addToCartDto, product, customer);
    }

    @GetMapping("/{customerId}")
    public CartDto getCart(@PathVariable Integer customerId) {
        return cartServices.listCartItems(this.customerService.getCustomerById(customerId));
    }

}
