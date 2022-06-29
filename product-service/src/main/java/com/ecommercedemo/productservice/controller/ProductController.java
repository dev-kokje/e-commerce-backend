package com.ecommercedemo.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercedemo.productservice.dto.ProductDto;
import com.ecommercedemo.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/products")
	public List<ProductDto> findAll() {
		return productService.findAll();
	}
	
	@GetMapping("/api/products/{id}")
	public ProductDto findById(@PathVariable String id) {
		return productService.findById(id);
	}
	
	@PostMapping("/api/products")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductDto save(@RequestBody ProductDto productDto) {
		return productService.save(productDto);
	}
	
	@DeleteMapping("/api/products/{id}")
	public void delete(@PathVariable String id) {
		productService.deleteById(id);
	}
	
	@PutMapping("/api/products")
	public ProductDto update(@RequestBody ProductDto productDto) {
		return productService.save(productDto);
	}
}
