package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Order;
import com.util.CreateSessionFactory;

public class OrdersApplication {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = CreateSessionFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		insertIntoTable(session);
//		fetchFromDB(session);
//		updateOrder(session);
//		deleteFromDB(session);
		
	}

	private static void deleteFromDB(Session session) {
		session.beginTransaction();
		Order removeObj = session.find(Order.class, 103);
		session.remove(removeObj);
		session.getTransaction().commit();
	}

	private static void updateOrder(Session session) {
		session.beginTransaction();
		Order updateOrderObj = session.find(Order.class, 103);
		session.merge(updateOrderObj);
		updateOrderObj.setPrice(9999);
		updateOrderObj.setQuantity(7);
		updateOrderObj.setStatus("PENDING");
		
		session.getTransaction().commit();
	}

	private static void fetchFromDB(Session session) {
		session.beginTransaction();
		Order localOrder = session.find(Order.class, 103);
		System.out.println(localOrder.toString());
	}

	private static void insertIntoTable(Session session) {
		Order order = new Order(105, "Kiran", "Keyboard", 2, 4500, "CANCELLED");
		session.beginTransaction();
		session.persist(order);
		session.getTransaction().commit();
	}
}
