package com.mapping.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mapping.entity.Course;
import com.mapping.entity.Student;
import com.mapping.util.HibernateDBConfig;

public class StudentCourseManyToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateDBConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
//		insert(session);

		Student student = session.find(Student.class, 2);
		System.out.println("\n1. Course details from Student Obj :: " + student.getCourses());
		Course course = session.find(Course.class, 3);
		System.out.println("\n2. Student details from Course Obj ::" + course.getStudents());

		System.out.println("\n3. Student obj before Update :: " + student);
		student.setCity("Chennai");
		session.merge(student);
		System.out.println("\n3. Student obj after Update :: " + student);

		Course fetchCourse1 = session.find(Course.class, 2);
		Course fetchCourse2 = session.find(Course.class, 3);
		Course fetchCourse3 = session.find(Course.class, 1);
		List<Course> newCourseList1 = new ArrayList<>(Arrays.asList(fetchCourse1, fetchCourse2));
		Student studentt = new Student("Ramu", "Ramu@gmail.com", "Banglore", newCourseList1);
		List<Course> newCourseList = new ArrayList<>(Arrays.asList(fetchCourse3, fetchCourse1, fetchCourse2));
		session.persist(studentt);
		Student student2 = session.find(Student.class, 1);
		System.out.println(
				"\n4. Student obj before Update :: " + student2 + "/n Courses :: --> " + student2.getCourses());
		student2.setCourses(newCourseList);
		session.merge(student2);
		System.out.println(
				"\n4--. Student obj after Update :: " + student2 + "/n Courses :: --> " + student2.getCourses());

		Student removeStudent = session.find(Student.class, 2);
		List<Course> courses = removeStudent.getCourses();
		removeStudent.getCourses().remove(courses);
		session.remove(removeStudent);

		System.out.println("After removing student id with 2:: " + session.find(Student.class, 2));

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	private static void insert(Session session) {
		Course course1 = new Course("Java", 4);
		Course course2 = new Course("Java Backend", 6);
		Course course3 = new Course("Frontend", 3);

		List<Course> courseList1 = new ArrayList<>(Arrays.asList(course1, course2));
		List<Course> courseList2 = new ArrayList<>(Arrays.asList(course1, course2, course3));
		List<Course> courseList3 = new ArrayList<>(Arrays.asList(course3, course2));

		Student student1 = new Student("Diwakar", "diwakar@gmail.com", "Hyderabad", courseList1);
		Student student2 = new Student("Ramu", "Ramu@gmail.com", "Banglore", courseList2);
		Student student3 = new Student("Laxman", "Laxman@gmail.com", "Mumbai", courseList3);

		session.persist(student1);
		session.persist(student2);
		session.persist(student3);
	}

}
