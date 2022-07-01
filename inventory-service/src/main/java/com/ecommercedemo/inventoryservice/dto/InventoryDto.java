package com.ecommercedemo.inventoryservice.dto;

public class InventoryDto {
	
	private String sku;
	private boolean isInStock;

	public InventoryDto() {
	}

	public InventoryDto(String sku, boolean isInStock) {
		super();
		this.sku = sku;
		this.isInStock = isInStock;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public boolean isInStock() {
		return isInStock;
	}

	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	@Override
	public String toString() {
		return "InventoryDto [sku=" + sku + ", isInStock=" + isInStock + "]";
	}
}
