package com.mapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "duration_of_course")
	private int durationInMonths;
	@ManyToMany(cascade = { 
			CascadeType.PERSIST,
			CascadeType.MERGE},
			fetch = FetchType.LAZY, mappedBy = "courses")
	private List<Student> students;
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String courseName, int durationInMonths, List<Student> students) {
		super();
		this.courseName = courseName;
		this.durationInMonths = durationInMonths;
		this.students = students;
	}
	public Course(String courseName, int durationInMonths) {
		super();
		this.courseName = courseName;
		this.durationInMonths = durationInMonths;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", durationInMonths=" + durationInMonths
				+ "]";
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDurationInMonths() {
		return durationInMonths;
	}
	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
