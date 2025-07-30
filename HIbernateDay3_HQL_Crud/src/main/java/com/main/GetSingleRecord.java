package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Student;

public class GetSingleRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Student where id =: id";
		Query<Student> query = ss.createQuery(hqlQuery);
		query.setParameter("id", 4);

		Student s = query.getSingleResult();
		System.out.println(s);

//		System.out.println("Data is deleted...");
		tr.commit();
		ss.close();

	}

}
