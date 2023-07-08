package com.nael.backend.service;

import com.nael.backend.Dto.product.ProductDto;
import com.nael.backend.entity.Product;
import com.nael.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        return productRepository.findById(product.getId()).map(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            return productRepository.save(p);
        }).orElseGet(() -> productRepository.save(product));
    }



}
