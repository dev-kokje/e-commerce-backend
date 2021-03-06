package com.ecommercedemo.productservice.dto;

public class ProductDto {

	private String id;
	
	private String sku;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	public ProductDto() {
	}

	public ProductDto(String id, String sku, String name, String description, Double price) {
		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", sku=" + sku + ", name=" + name + ", description=" + description + ", price="
				+ price + "]";
	}
}
