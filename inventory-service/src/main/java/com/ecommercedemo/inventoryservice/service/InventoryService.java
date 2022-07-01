package com.ecommercedemo.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercedemo.inventoryservice.dto.InventoryDto;
import com.ecommercedemo.inventoryservice.model.Inventory;
import com.ecommercedemo.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	public InventoryDto isInStock(String sku, int quantity) {
		
		Optional<Inventory> inventoryObj = inventoryRepository.findBySku(sku);
		
		if(inventoryObj.isEmpty()) {
			throw new RuntimeException("Record not found for sku - " + sku);
		}
		
		Inventory inventory = inventoryObj.get();
		
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setSku(inventory.getSku());
		inventoryDto.setInStock(inventory.getQuantity() >= quantity);
		
		return inventoryDto;
	}
	
	public List<Inventory> findAll() {
		return inventoryRepository.findAll();
	}
	
	public Inventory findById(Long id) {
		Optional<Inventory> inventory = inventoryRepository.findById(id);
		
		if(inventory.isEmpty()) {
			throw new RuntimeException("Inventory with id - " + id + " not found.");
		}
		
		return inventory.get();
	}
	
	public Inventory save(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
}
