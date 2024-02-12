package com.example.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagement.dto.CategoryDto;
import com.example.productmanagement.dto.ResponseDto;
import com.example.productmanagement.service.CategoryService;

@RestController
@RequestMapping("/api/getAllCategory")
public class CategoryController {

		@Autowired
		public CategoryService categoryService;
		
		@GetMapping("")
		public ResponseDto getAll() {
			return new ResponseDto(200, "Success!", categoryService.fetchAll());
		}
		
		@PostMapping({"/addCategory","/updateCategory"})
		public ResponseDto addCategory(@RequestBody CategoryDto categoryDto) {
			categoryService.addCategory(categoryDto);
			return new ResponseDto( 200 , "Added!" ,"");
		}
		
		@GetMapping("/getCategoryById")
		public ResponseDto getCategoryById(@RequestParam Long id) {
			return new ResponseDto(200, "Success! ", categoryService.getCategoryById(id));
		}
		
		@DeleteMapping("/deleteCategoryById")
		public String deleteCategoryById(@RequestParam long id) {
			categoryService.deleteById(id);
			return "Deleted!";
		}
}
