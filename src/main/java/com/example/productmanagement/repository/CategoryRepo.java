package com.example.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
