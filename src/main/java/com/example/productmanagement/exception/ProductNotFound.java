package com.example.productmanagement.exception;

public class ProductNotFound extends RuntimeException{
	public ProductNotFound() {
		super();
	}
	public ProductNotFound(String message) {
		super(message);
	}

}
