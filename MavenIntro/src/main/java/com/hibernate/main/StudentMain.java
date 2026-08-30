package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.StudentCRUD;

public class StudentMain {

	public static void main(String[] args) {
		
		//Step-1 : Config for DB Connection
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		//Step 2: Register Entity :
		config.addAnnotatedClass(StudentCRUD.class);

		// Step 3 : Session creation using Session Factory
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//step 4 : begin transaction
		 session.beginTransaction();
		//Step 5 : Create POJO Object for insetion;
		
		StudentCRUD student = new StudentCRUD(2, "Ram", 28, "JavaFullStack");
		session.persist(student);
		session.getTransaction().commit();
		System.out.println("Insert successful.");
	}

}
