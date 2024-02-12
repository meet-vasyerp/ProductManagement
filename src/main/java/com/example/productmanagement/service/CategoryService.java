package com.example.productmanagement.service;

import java.util.List;

import com.example.productmanagement.dto.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> fetchAll();
	
	void addCategory(CategoryDto categoryDto);
	
	void deleteById(long id);
	
	CategoryDto getCategoryById(long id);
}
