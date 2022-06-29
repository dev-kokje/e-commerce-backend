package com.ecommercedemo.orderservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommercedemo.orderservice.dto.OrderDto;
import com.ecommercedemo.orderservice.model.Order;
import com.ecommercedemo.orderservice.model.OrderItem;
import com.ecommercedemo.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OrderDto placeOrder(OrderDto orderDto) {
		
		Order order = dtoToOrder(orderDto);
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setOrderDate(new java.sql.Date(new Date().getTime()));
		
		List<OrderItem> orderItemsList = order.getOrderItemsList();
		Double sum = 0.0;
		
		if(orderItemsList != null) {
			sum = orderItemsList.stream()
					.mapToDouble(productItem -> productItem.getPrice() * productItem.getQuantity())
					.sum();
		}
		
		order.setTotalCost(sum);
		
		Order newOrder = orderRepository.save(order);
		
		return orderToDto(newOrder);
	}
	
	public OrderDto getOrderDetails(String orderNumber) {
		Optional<Order> order = orderRepository.findByOrderNumber(orderNumber);
		
		if(order.isEmpty()) {
			throw new RuntimeException("Order with order number " + orderNumber + " not found.");
		}
		
		return orderToDto(order.get());
	}
	
	private Order dtoToOrder(OrderDto orderDto) {
		return modelMapper.map(orderDto, Order.class);
	}
	
	private OrderDto orderToDto(Order order) {
		return modelMapper.map(order, OrderDto.class);
	}
}
