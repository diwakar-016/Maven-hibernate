package com.mapping.service;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mapping.entity.Customer;
import com.mapping.entity.Order;
import com.mapping.util.HibernateDBConfig;

public class CustomerOrderOneTOManyManyToOneMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateDBConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Insertion 
//		insert(session);
//		fetch(session);
		Order updateOrder = fetch(session, 3);
		updateOrder.setAmount(999.99);;
		session.merge(updateOrder);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	private static Order fetch(Session session, int id) {
		Customer customer = session.find(Customer.class, 1);
		Order order = session.find(Order.class, id);
		System.out.println("\n\nOrder Detils :: "+order);
		System.out.println("\n\nCustomer details from Order details Obj:: "+order.getCustomer());
		
		System.out.println("\n\nCustomer Detils :: "+customer);
		System.out.println("\n\nOrder details from Custiomerdetails Obj:: "+customer.getOrders());
		
		return order;
	}

	private static void insert(Session session) {
		Customer customer1 = new Customer(
		        "Diwakar",
		        "Hyderabad",
		        "diwakar@gmail.com",
		        9876543210L
		);

		Order order1 = new Order(
		        "Laptop",
		        65000,
		        LocalDate.of(2026, 9, 1),
		        customer1
		);

		Order order2 = new Order(
		        "Mouse",
		        1200,
		        LocalDate.of(2026, 9, 2),
		        customer1
		);

		Order order3 = new Order(
		        "Keyboard",
		        2500,
		        LocalDate.of(2026, 9, 3),
		        customer1
		);
		
		Customer customer2 = new Customer(
		        "Rahul",
		        "Bangalore",
		        "rahul@gmail.com",
		        9123456789L
		);

		Order order4 = new Order(
		        "Monitor",
		        15000,
		        LocalDate.of(2026, 9, 4),
		        customer2
		);

		Order order5 = new Order(
		        "Headphones",
		        3500,
		        LocalDate.of(2026, 9, 5),
		        customer2
		);
		
		
		session.persist(order1);
		session.persist(order2);
		session.persist(order3);
		session.persist(order4);
		session.persist(order5);
	}

}
