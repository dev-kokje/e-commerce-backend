package com.ecommercedemo.inventoryservice.model;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "last_updated_dt")
	private Timestamp lastUpdatedDate;
	
	public Inventory() {
	}

	public Inventory(Long id, String sku, int quantity, Timestamp lastUpdatedDate) {
		super();
		this.id = id;
		this.sku = sku;
		this.quantity = quantity;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", sku=" + sku + ", quantity=" + quantity + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lastUpdatedDate, quantity, sku);
	}
}
