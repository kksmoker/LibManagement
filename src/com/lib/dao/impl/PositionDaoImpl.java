package com.lib.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.lib.dao.PositionDao;
import com.lib.domain.Position;

public class PositionDaoImpl implements PositionDao {
	private SessionFactory sessionFactory;
	
	@Override
	public Position getById(int id) {
		return (Position) sessionFactory.getCurrentSession().get(Position.class, id);
	}

	@Override
	public void save(Position position) {
		sessionFactory.getCurrentSession().save(position);
	}

	@Override
	public void update(Position position) {
		sessionFactory.getCurrentSession().update(position);
	}

	@Override
	public void delete(int id) {
		Position position = (Position) sessionFactory.getCurrentSession().get(Position.class, id);
		if (position != null) {
			sessionFactory.getCurrentSession().delete(position);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> listAll() {
		return sessionFactory.getCurrentSession().createQuery("from Position").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Position getByFloor(String floor) {
		return (Position) sessionFactory.getCurrentSession()
				.createQuery("from Position as position where position.floor=?")
				.setString(0, floor)
				.uniqueResult();
	}

}
