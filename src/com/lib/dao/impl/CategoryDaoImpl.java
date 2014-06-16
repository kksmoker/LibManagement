package com.lib.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import com.lib.dao.CategoryDao;
import com.lib.domain.Category;

public class CategoryDaoImpl implements CategoryDao {
	private SessionFactory sessionFactory;

	@Override
	public Category getById(int id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}
	
	@Override
	public Category getByName(String name) {
		return (Category) sessionFactory.getCurrentSession()
				.createQuery("from Category as category where category.name=?")
				.setString(0, name)
				.uniqueResult();
	}

	@Override
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Override
	public void delete(int id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
		if (category != null) {
			sessionFactory.getCurrentSession().delete(category);
		}
	}

	@Override
	public void save(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listAll() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
