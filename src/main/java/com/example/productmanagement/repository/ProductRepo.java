package com.example.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
