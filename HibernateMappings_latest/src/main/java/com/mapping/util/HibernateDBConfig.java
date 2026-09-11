package com.mapping.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Aadhar;
import com.mapping.entity.Citizen;
import com.mapping.entity.Course;
import com.mapping.entity.Customer;
import com.mapping.entity.Department;
import com.mapping.entity.Employee;
import com.mapping.entity.Order;
import com.mapping.entity.Student;

public class HibernateDBConfig {
	
	public static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure();
			
			//OneToOne Mapping
			config.addAnnotatedClass(Citizen.class);
			config.addAnnotatedClass(Aadhar.class);
			//OneToMany Mapping
			config.addAnnotatedClass(Employee.class);
			config.addAnnotatedClass(Department.class);
			//OneToMany Mapping
			config.addAnnotatedClass(Order.class);
			config.addAnnotatedClass(Customer.class);
			//ManyToMany Mapping
			config.addAnnotatedClass(Course.class);
			config.addAnnotatedClass(Student.class);
			
			sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		}else
			return sessionFactory;
	}
}
