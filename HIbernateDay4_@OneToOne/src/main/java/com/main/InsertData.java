package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Laptop;
import com.entity.Student;

public class InsertData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Laptop l = new Laptop();
		l.setL_id(210000);
		l.setL_name("HP");
		ss.persist(l);

		Student s = new Student();
		s.setName("rahul");
		s.setAge(33);
		s.setLaptop(l);

		ss.persist(s);
		tr.commit();
		ss.close();

		System.out.println("Data is inserted...");

	}

}
