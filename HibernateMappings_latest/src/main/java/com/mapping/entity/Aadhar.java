package com.mapping.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Aadhar {
	@Id
	@Column(name="aadhar_number")
	private long aadhaarNumber;
	@Column(name="father_name")
	private String fatherName;
	private LocalDate dateOfBirth;
	@OneToOne(mappedBy = "aadhar", fetch = FetchType.LAZY)
	private Citizen citizen;
	public long getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public Aadhar(long aadhaarNumber, String fatherName, LocalDate dateOfBirth) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.fatherName = fatherName;
		this.dateOfBirth = dateOfBirth;
	}
	public Aadhar() {
	}
	@Override
	public String toString() {
		return "Aadhar [aadhaarNumber=" + aadhaarNumber + ", fatherName=" + fatherName + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	
	
}
