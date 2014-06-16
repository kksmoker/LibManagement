package com.lib.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.lib.dao.UserDao;
import com.lib.domain.User;


public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	@Override
	public User getByName(int name) {
		return (User) sessionFactory.getCurrentSession()
			.createQuery("from User as user where user.name=?")
			.setInteger(0, name).uniqueResult();
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delete(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getByEmail(String email) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("from User as user where user.email=?")
				.setString(0, email)
				.uniqueResult();
	}

	@Override
	public User getById(int uid) {
		return (User) sessionFactory.getCurrentSession().get(User.class, uid);
	}

}
