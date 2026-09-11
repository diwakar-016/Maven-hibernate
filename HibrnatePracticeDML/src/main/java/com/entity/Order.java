package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	@Id 
	@Column(name = "order_id") 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(name = "customer_name") 
	private String customerName;
	@Column(name = "product_ame") 
	private String productName;
	private int quantity;
	private int price;
	private String status;
	public Order(int orderId, String customerName, String productName, int quantity, int price, String status) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	public Order() {
		super();
	}
	public Order(String customerName, String productName, int quantity, int price, String status) {
		super();
		this.customerName = customerName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + ", status=" + status + "]";
	}
	
	
}
