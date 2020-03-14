package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			Student student = session.get(Student.class, studentId);
//			session.delete(student);
			
			// delete student id=2
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
