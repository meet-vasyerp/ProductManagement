package com.example.productmanagement.service;

import java.util.List;

import com.example.productmanagement.dto.ProductDto;

public interface ProductService {

	List<ProductDto> fetchAll();
	
	void addProduct(ProductDto productDto);
	
	ProductDto getProductById(long productId);
	
	void deleteProductById(long productId);
}
