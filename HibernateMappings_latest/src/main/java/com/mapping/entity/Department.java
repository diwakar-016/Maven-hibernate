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
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name="department_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int departmentId;
	private String name;
	private String location;
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			mappedBy = "department"
			)
	private List<Employee> employees;
	public Department(String name, String location, List<Employee> employees) {
		super();
		this.name = name;
		this.location = location;
		this.employees = employees;
	}
	public Department(int departmentId, String name, String location) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.location = location;
	}
	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public Department() {
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", location=" + location + "]";
	}
}
