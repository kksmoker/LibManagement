package com.lib.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.lib.dao.BooksDao;
import com.lib.domain.Books;

public class BooksDaoImpl implements BooksDao {
	private SessionFactory sessionFactory;

	@Override
	public Books getById(int id) {
		return (Books) sessionFactory.getCurrentSession().get(Books.class, id);
	}

	@Override
	public Books getByBarcode(String barcode) {
		return (Books) sessionFactory.getCurrentSession()
				.createQuery("from Books as books where books.barcode=?")
				.setString(0, barcode).uniqueResult();
	}

	@Override
	public void update(Books books) {
		sessionFactory.getCurrentSession().update(books);
	}

	@Override
	public void delete(int id) {
		Books books = (Books) sessionFactory.getCurrentSession().get(Books.class, id);
		if (books != null) {
			sessionFactory.getCurrentSession().delete(books);
		}
	}

	@Override
	public void save(Books books) {
		sessionFactory.getCurrentSession().save(books);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Books> searchByPress(String press) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Books as books where books.press like ?")
				.setString(0, "%" + press + "%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Books> searchByName(String name) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Books as books where books.name like ?")
				.setString(0, "%" + name + "%").list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
