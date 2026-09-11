package com.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * It allows Hibernate to properly understand the generated-ID behavior and
	 * retrieve/use the generated identifier after insertion. As Id is auto
	 * increment in SQL, for better understanding and behaviour in
	 * hibernate @GeneratedValue(GenerationType.IDENTITY) is used.
	 */
	private int employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "email")
	private String email;
	@Column(name = "salary")
	private double salary;
	@Column(name = "department")
	private String department;
	@Column(name = "joining_date")
	private Date joiningDate;

	public Employee() {
		super();
	}

	public Employee(String employeeName, String email, double salary, String department, Date joiningDate) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.joiningDate = joiningDate;
	}

	public Employee(int employeeId, String employeeName, String email, double salary, String department,
			Date joiningDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.joiningDate = joiningDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", salary=" + salary + ", department=" + department + ", joiningDate=" + joiningDate + "]";
	}

}
