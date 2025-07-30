package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.entity.Student;

public class UpdateData {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Student set name=:myname, city=:address where stud_id=:id";

		MutationQuery query = ss.createMutationQuery(hqlQuery);
		query.setParameter("myname", "rahul");
		query.setParameter("address", "nashik");
		query.setParameter("id", 5);
		query.executeUpdate();

		System.out.println("Data is updated...");
		tr.commit();
		ss.close();

	}

}
