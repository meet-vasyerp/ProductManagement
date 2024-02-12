package com.example.productmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="product_price")
	private long productPrice; 
	@Column(name="product_desc")
	private String productDesc;
	
	@ManyToOne
	public Category category;
	
}
