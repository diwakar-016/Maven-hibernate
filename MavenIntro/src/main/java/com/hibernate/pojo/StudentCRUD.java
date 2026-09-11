package com.hibernate.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentCRUD {
	@Id
	private int id;
	private String name;
	private int age;
	private String course;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public StudentCRUD(int id, String name, int age, String course) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.course = course;
	}
	public StudentCRUD(String name, int age, String course) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
	}
	public StudentCRUD(){
		
	}
	@Override
	public String toString() {
		return "StudentCRUD [id=" + id + ", name=" + name + ", age=" + age + ", course=" + course + "]";
	}
	
	
}
