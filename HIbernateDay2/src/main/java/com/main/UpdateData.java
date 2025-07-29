package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 3;
		Student s = ss.get(Student.class, id);
		s.setAge(34);
		s.setCity("akola");
		s.setName("Ram");
		s.setSurname("kale");

//		ss.update(s);
		ss.merge(s);

		System.out.println("Data is updated...");
		tr.commit();
		ss.close();

	}

}
