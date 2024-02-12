package com.example.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagement.dto.ProductDto;
import com.example.productmanagement.dto.ResponseDto;
import com.example.productmanagement.service.ProductService;

@RestController
@RequestMapping("/api/getAllProducts")
public class ProductController {

	@Autowired
	public ProductService productService;
	
	@GetMapping("")
	public ResponseDto fectAllProducts() {
		return new ResponseDto(200,"SUCCESS !",productService.fetchAll());
	}
	
	@PostMapping({"/addProducts","/updateProduct"})
	public ResponseDto addProducts(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		return new ResponseDto(200, "Success !", productService.fetchAll());
	}
	
	@GetMapping("/getProductById")
	public ResponseDto getProductById(@RequestParam long productId) {
		return new ResponseDto(200, "Success",productService.getProductById(productId));
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseDto deleteProductById(@RequestParam long productId) {
		productService.deleteProductById(productId);
		return new ResponseDto(200, "Deleted !","");
	}
}
