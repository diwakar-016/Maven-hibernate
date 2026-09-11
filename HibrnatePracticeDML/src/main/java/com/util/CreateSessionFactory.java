package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Order;

public class CreateSessionFactory {

	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();

			config.addAnnotatedClass(Order.class);
			config.configure();
//			config.configure("hibernate.cfg.xml");

			sessionFactory = config.buildSessionFactory();
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
