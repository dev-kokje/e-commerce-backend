package com.ecommercedemo.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommercedemo.orderservice.dto.OrderDto;
import com.ecommercedemo.orderservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/api/orders")
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderDto placeOrder(@RequestBody OrderDto orderDto) {
		return orderService.placeOrder(orderDto);
	}
	
	@GetMapping("/api/orders/{orderNumber}")
	public OrderDto getOrderDetails(@PathVariable String orderNumber) {
		return orderService.getOrderDetails(orderNumber);
	}
}
