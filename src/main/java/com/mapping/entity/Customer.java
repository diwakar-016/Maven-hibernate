package com.mapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	private String name;
	private String address;
	private String email;
	private long mobile; 
	@OneToMany(mappedBy = "customer",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Order> orders;
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	public Customer() {
		
	}
	public Customer(int customerId, String name, String address, String email, long mobile) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	public Customer(String name, String address, String email, long mobile, List<Order> orders) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.orders = orders;
	}
	public Customer(String name, String address, String email, long mobile) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
