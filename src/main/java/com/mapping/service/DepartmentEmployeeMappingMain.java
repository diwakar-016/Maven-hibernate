package com.mapping.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mapping.entity.Department;
import com.mapping.entity.Employee;
import com.mapping.util.HibernateDBConfig;

public class DepartmentEmployeeMappingMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateDBConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
//		insert(session);
		Department departmentFetch = session.find(Department.class, 1);
		List<Employee> employees = departmentFetch.getEmployees();
		System.out.println(employees);
		
		Employee employeeFetch = session.find(Employee.class, 2);
		Department department = employeeFetch.getDepartment();
		System.out.println(department);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	private static void insert(Session session) {
		Department department1 = new Department("IT", "Hyderabad");
		Department department2 = new Department("HR", "Bangalore");
		
		Employee employee1 = new Employee("Diwakar", 60000);
		Employee employee2 = new Employee("Rahul", 55000);
		Employee employee3 = new Employee("Kiran", 50000);
		Employee employee4 = new Employee("Arjun", 45000);
		Employee employee5 = new Employee("Rohit", 48000);
		
		employee1.setDepartment(department1);
		employee2.setDepartment(department1);
		employee3.setDepartment(department1);
		employee4.setDepartment(department2);
		employee5.setDepartment(department2);
		
		department1.setEmployees(List.of(employee1, employee2, employee3));
		department2.setEmployees(List.of(employee4, employee5));
		
		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);
		session.persist(employee4);
		session.persist(employee5);
	}

}
