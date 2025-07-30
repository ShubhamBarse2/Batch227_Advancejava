package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Student;

public class FetchAllRecord {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

//		CriteriaBuilder hcb = ss.getCriteriaBuilder();
//		CriteriaQuery<Object> cb = hcb.createQuery();
//		Root<Student> root = cb.from(Student.class);
//		cb.select(root);
//
//		Query query = ss.createQuery(cb);
//		List<Student> list = query.getResultList();
//
//		for (Student student : list) {
//			System.out.println(student);
//		}

		// sql : // select * from student;

//	   hql : from Student;

		String hqlQuery = "from Student";
//		Query query = ss.createQuery(hqlQuery, Student.class);
//		List<Student> list = query.getResultList();

		Query<Student> query = ss.createQuery(hqlQuery, Student.class);
		List<Student> list = query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}

	}

}
