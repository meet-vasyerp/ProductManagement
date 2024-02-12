package com.example.productmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.dto.ProductDto;
import com.example.productmanagement.exception.ProductNotFound;
import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	public ProductRepo productRepo;
	
	@Override
	public List<ProductDto> fetchAll() {
		List<Product> products = productRepo.findAll();
		List<ProductDto> productDto = new ArrayList<>();
	
		for (Product product : products) {
			ProductDto dto = new ProductDto();
			dto.setProductId(product.getProductId());
			dto.setProductName(product.getProductName());
			dto.setProductPrice(product.getProductPrice());
			dto.setProductDesc(product.getProductDesc());
			dto.setCategory(product.getCategory());
			productDto.add(dto);
		}
		return productDto;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		Product product;
		if(productDto.getProductId() == 0) {
			product= new Product();
		}else {
			product=productRepo.findById(productDto.getProductId()).get();
		}
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setProductPrice(product.getProductPrice());
		product.setProductDesc(product.getProductDesc());
		product.setCategory(product.getCategory());		productRepo.save(product);
		}

	@Override
	public ProductDto getProductById(long productId) {
		Product product = productRepo.findById(productId).orElseThrow(()->new ProductNotFound("Product Id is Invalid !"));
		ProductDto projDto = new ProductDto();
		projDto.setProductId(product.getProductId());
		projDto.setProductName(product.getProductName());
		projDto.setProductDesc(product.getProductDesc());
		projDto.setCategory(product.getCategory());
		return projDto;
	}

	@Override
	public void deleteProductById(long productId) {
		productRepo.deleteById(productId);
	}
	
	
	

}
