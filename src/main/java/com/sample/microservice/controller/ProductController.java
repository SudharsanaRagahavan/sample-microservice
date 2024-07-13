package com.sample.microservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.microservice.entity.Product;
import com.sample.microservice.entity.User;
import com.sample.microservice.repo.ProductRepo;
import com.sample.microservice.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Product> createProductForUser(@PathVariable Long userId, @RequestBody Product product) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user = optionalUser.get();
        product.setUser(user);
        Product newProduct = productRepository.save(product);
        user.getProducts().add(newProduct);
        userRepository.save(user); // Update user with new product
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Other CRUD methods for products
}

