package com.mapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Student {
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String name;
	private String email;
	private String city;
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	},
			fetch = FetchType.LAZY)
	@JoinTable(
			name = "student_course",
			joinColumns = @JoinColumn(name ="student_id"),
			inverseJoinColumns = @JoinColumn(name ="course_id")
			)
	private List<Course> courses;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String email, String city, List<Course> courses) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
		this.courses = courses;
	}
	
	public Student(String name, String email, String city) {
		super();
		this.name = name;
		this.email = email;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", email=" + email + ", city=" + city + "]";
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
	
}
