package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entities.Student;

public class StudentDao {

	public void insertData(Student s) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Student(age,address,name,surname)values(:age,:address,:name,:surname)";
		MutationQuery query = ss.createNativeMutationQuery(hqlQuery);
		query.setParameter("age", 24);
		query.setParameter("address", "karachi");
		query.setParameter("name", "mahi");
		query.setParameter("surname", "dalal");
		query.executeUpdate();

		System.out.println("Data is inserted...");
		tr.commit();
		ss.close();
		
	}
	
}
