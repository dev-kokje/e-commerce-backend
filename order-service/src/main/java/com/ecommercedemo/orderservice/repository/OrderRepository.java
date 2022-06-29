package com.ecommercedemo.orderservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommercedemo.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	public Optional<Order> findByOrderNumber(String orderNumber);
}
