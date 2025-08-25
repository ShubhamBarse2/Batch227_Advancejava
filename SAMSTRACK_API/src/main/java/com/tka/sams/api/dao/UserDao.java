package com.tka.sams.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.sams.api.entity.User;
import com.tka.sams.api.model.LoginRequest;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory factory;

	public User loginUser(LoginRequest request) {
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			user = session.get(User.class, request.getUsername());
			if (user != null) {
				if (user.getPassword().equals(request.getPassword())) {
					return user;
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleteUserById(String username) {
		Session session = null;
		String msg = null;
		try {
			session = factory.openSession();
			User user = session.get(User.class, username);
			session.delete(user);
			session.beginTransaction().commit();
			msg = "deleted";

		} catch (Exception e) {
			msg = null;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}

	public User updateUser(User user) {
		Session session = null;

		try {
			session = factory.openSession();
			session.update(user);
			session.beginTransaction().commit();
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUser() {
		Session session = null;
		List<User> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public User getUserByName(String username) {
		Session session = null;
		User user = null;
		try {
			session = factory.openSession();
			user = session.get(User.class, username);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return user;
	}

	public User registerUser(User user) {
		Session session = null;
		User user2 = null;
		try {
			session = factory.openSession();
			user2 = session.get(User.class, user.getUsername());
			if (user2 == null) {
				session.save(user);
				session.beginTransaction().commit();
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return null;
	}

	public List<User> getAllAdmins() {
		Session session = null;
		List<User> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("role", "admin"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<User> getAllFaculties() {
		Session session = null;
		List<User> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("role", "faculty"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
