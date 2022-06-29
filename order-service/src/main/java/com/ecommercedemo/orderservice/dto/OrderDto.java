package com.ecommercedemo.orderservice.dto;

import java.sql.Date;
import java.util.List;

import com.ecommercedemo.orderservice.model.OrderItem;

public class OrderDto {

	private Long id;
	
	private String orderNumber;
	
	private Date orderDate;
	
	private Double totalCost;
	
	private List<OrderItem> orderItemsList;
	
	public OrderDto() {
	}

	public OrderDto(Long id, String orderNumber, Date orderDate, Double totalCost, List<OrderItem> orderItemsList) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.totalCost = totalCost;
		this.orderItemsList = orderItemsList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public List<OrderItem> getOrderItemsList() {
		return orderItemsList;
	}

	public void setOrderItemsList(List<OrderItem> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}

	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", totalCost="
				+ totalCost + ", orderItemsList=" + orderItemsList + "]";
	}
}
