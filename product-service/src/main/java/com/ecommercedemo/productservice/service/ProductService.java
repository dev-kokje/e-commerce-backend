package com.ecommercedemo.productservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercedemo.productservice.dto.ProductDto;
import com.ecommercedemo.productservice.exception.ProductNotFoundException;
import com.ecommercedemo.productservice.model.Product;
import com.ecommercedemo.productservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ProductDto> findAll() {
		List<Product> productsList = productRepository.findAll();
		
		return productsList.stream()
					.map(this::productToDto)
					.toList();
	}
	
	public ProductDto findById(String id) {
		Optional<Product> product = productRepository.findById(id);
		
		if(product.isEmpty()) {
			throw new ProductNotFoundException("Product with id " + id + " not found.");
		}
		
		return this.productToDto(product.get());
	}
	
	public ProductDto save(ProductDto productDto) {
		Product product = this.dtoToProduct(productDto);
		
		if(product.getSku() == null || product.getSku().isBlank()) {
			product.setSku(UUID.randomUUID().toString());
		}
		
		Product newProduct = productRepository.save(product);
		return this.productToDto(newProduct);
	}
	
	public void deleteById(String id) {
		ProductDto productDto = this.findById(id);
		Product product = this.dtoToProduct(productDto);
		productRepository.delete(product);
	}
	
	private Product dtoToProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		return product;
	}
	
	private ProductDto productToDto(Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}
}
