package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Student tempStudent = new Student("larry", "morry", "johjp@ffr.rrr");
			Student tempStudent2 = new Student("chris", "bro", "johjp@ffr.rrr");
			Student tempStudent3 = new Student("larry", "king", "johjp@ffr.rrr");

			session.beginTransaction();
			
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
