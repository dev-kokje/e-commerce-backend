package com.ecommercedemo.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommercedemo.productservice.exception.ExceptionCode;
import com.ecommercedemo.productservice.exception.ExceptionResponse;
import com.ecommercedemo.productservice.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductControllerAdvice {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleProductNotFoundException(ProductNotFoundException e) {
		ExceptionCode code = ExceptionCode.PR001;
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ExceptionResponse(code, status, e.getMessage());
	}
}
