package com.ecommercedemo.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercedemo.inventoryservice.dto.InventoryDto;
import com.ecommercedemo.inventoryservice.model.Inventory;
import com.ecommercedemo.inventoryservice.service.InventoryService;

@RestController
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/api/inventory")
	public List<Inventory> findAll() {
		return inventoryService.findAll();
	}
	
	@PostMapping("/api/inventory")
	public Inventory add(@RequestBody Inventory inventory) {
		return inventoryService.save(inventory);
	}
	
	@GetMapping("/api/inventory/{sku}")
	public InventoryDto isInStock(@PathVariable String sku, @RequestParam(name = "quantity") int quantity) {
		return inventoryService.isInStock(sku, quantity);
	}
}
