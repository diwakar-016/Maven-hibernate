package com.service;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.util.SessionFactoryConfig;

public class EmployeeMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryConfig.getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		find(session,id);
//		insert(session);
//		update(session);
		int id = 3;
		delete(session, id); // pass id :: 
		

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	private static void delete(Session session, int id) {
		Employee deleteEmp = find(session,id);
		if(deleteEmp != null) {
			session.remove(deleteEmp);
			System.out.println("Record deleted.");
		}else {
			System.out.println("Record not found.!!!");
		}
	}

	private static void update(Session session) {
		Employee employee = find(session, 3);
		session.merge(employee);
		employee.setSalary(77000.00); 
		/* dirty checking :: transaction begin to commit all the statements get executes
										 even merg() happens before setting the data*/
	}

	private static void insert(Session session) {
		Employee insertEmployee = new Employee("Test", "test@gmail.com", 27000.00, "Finance",
				Date.valueOf(LocalDate.now()));

		session.persist(insertEmployee);
	}

	private static Employee find(Session session, int id) {
		Employee findEmployee = session.find(Employee.class, id);
		System.out.println(findEmployee);
		if(findEmployee != null)
			return findEmployee;
		else 
			System.out.println("Record with employee id : "+id +"is not present in DB.");
			return null;
	}

}
