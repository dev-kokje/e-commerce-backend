package com.ecommercedemo.productservice.exception;

public class ProductNotFoundException extends RuntimeException {

	private String message;
	
	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
