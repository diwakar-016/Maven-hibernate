package com.mapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Citizen")

public class Citizen {
	@Id
	@Column(name= "citizen_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citizenId;
	private String name;
	private int age;
	private String city;
	
	@JoinColumn(name = "aadhar_number", unique = true)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Aadhar aadhar;
	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
	
	public Citizen(String name, int age, String city, Aadhar aadhar) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.aadhar = aadhar;
	}

	public Citizen(int citizenId, String name, int age, String city, Aadhar aadhar) {
		super();
		this.citizenId = citizenId;
		this.name = name;
		this.age = age;
		this.city = city;
		this.aadhar = aadhar;
	}

	public Citizen(int citizenId, String name, int age, String city) {
		super();
		this.citizenId = citizenId;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public Citizen() {
	}

	public int getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(int citizenId) {
		this.citizenId = citizenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
}
