package com.sample.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.microservice.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
