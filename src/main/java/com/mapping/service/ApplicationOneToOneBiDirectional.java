package com.mapping.service;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mapping.entity.Aadhar;
import com.mapping.entity.Citizen;
import com.mapping.util.HibernateDBConfig;

public class ApplicationOneToOneBiDirectional {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateDBConfig.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Citizen citizen1 = new Citizen(
			    "Arjun",
			    28,
			    "Hyderabad",
			    new Aadhar(123456789012L, "Ramesh Kumar", LocalDate.of(1998, 5, 15))
			);

			Citizen citizen2 = new Citizen(
			    "Rahul",
			    31,
			    "Bangalore",
			    new Aadhar(234567890123L, "Suresh Kumar", LocalDate.of(1995, 11, 20))
			);

			Citizen citizen3 = new Citizen(
			    "Kiran",
			    26,
			    "Chennai",
			    new Aadhar(345678901234L, "Ravi Kumar", LocalDate.of(2000, 2, 10))
			);
		
		
		session.beginTransaction();
//		insert(session, citizen1, citizen2, citizen3);
		
//		fetchAadharFromCitizen(session);
//		fetchCitizenFromAadhar(session);
		
		Citizen updateCitizen = new Citizen(
			    "Kiran",
			    26,
			    "Chennai",
			    new Aadhar(345678901234L, "Ravi Kumar RK", null)
			);

			updateCitizen.setCitizenId(3);

			session.merge(updateCitizen);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}

	private static void fetchCitizenFromAadhar(Session session) {
		Aadhar fetchedAadhar = session.find(Aadhar.class, 345678901234L);
		System.out.println(fetchedAadhar);
		System.out.println(fetchedAadhar.getCitizen());
	}

	private static void fetchAadharFromCitizen(Session session) {
		Citizen FetchedCitizen = session.find(Citizen.class, 1);
		System.out.println(FetchedCitizen);
		System.out.println(FetchedCitizen.getAadhar());
		
	}

	private static void insert(Session session, Citizen citizen1, Citizen citizen2, Citizen citizen3) {
		session.persist(citizen1);
		session.persist(citizen2);
		session.persist(citizen3);
	}

}
