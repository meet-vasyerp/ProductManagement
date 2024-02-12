package com.example.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.dto.CategoryDto;
import com.example.productmanagement.model.Category;
import com.example.productmanagement.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	public CategoryRepo categoryRepo;
	
	@Override
	public List<CategoryDto> fetchAll() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> categoryDto = new ArrayList<>();
		
		for (Category category1 : categories) {
			CategoryDto cateDto  = new CategoryDto();
			cateDto.setCategoryID(category1.getCategoryID());
			cateDto.setCategoryName(category1.getCategoryName());
			categoryDto.add(cateDto);
		}
		return categoryDto;
	}

	@Override
	public void addCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryID(categoryDto.getCategoryID());
		category.setCategoryName(categoryDto.getCategoryName());
		categoryRepo.save(category);
	}

	@Override
	public void deleteById(long id) {
		categoryRepo.deleteById(id);
	}


	@Override
	public CategoryDto getCategoryById(long id) {
		Category category=categoryRepo.findById(id).get();
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryID(category.getCategoryID());
		categoryDto.setCategoryName(category.getCategoryName());
		return categoryDto;
	}
	
}
