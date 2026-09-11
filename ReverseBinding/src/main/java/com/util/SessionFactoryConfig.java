package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class SessionFactoryConfig {
	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		
		
		config.configure();
		config.addAnnotatedClass(Employee.class);
		
		if (sessionFactory == null) {
			sessionFactory = config.buildSessionFactory();
			
			return sessionFactory;
		}else
			return sessionFactory;
	}

}
