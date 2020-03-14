package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			List<Student> theStudentsList = session.createQuery("from Student").getResultList();
			
//			displayStudents(theStudentsList);
			
			theStudentsList = session.createQuery("from Student s where s.lastName='bro'").getResultList(); 
			
//			System.out.println("with last name bro: ");
//			displayStudents(theStudentsList);
			
//			System.out.println("Or query");
			theStudentsList = session.createQuery("from Student s where "
					+ "s.lastName='bro' OR s.firstName='chris'").getResultList();
//			displayStudents(theStudentsList);
			
			System.out.println("LIKE");
			theStudentsList = session.createQuery("from Student s where "
					+ "s.email LIKE '%@tt.ttt'").getResultList();
			displayStudents(theStudentsList);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudentsList) {
		for(Student st: theStudentsList) {
			System.out.println(st);
		}
	}

}
