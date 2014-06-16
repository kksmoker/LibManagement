package com.lib.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.lib.dao.SearchRecordDao;
import com.lib.domain.SearchRecord;

public class SearchRecordDaoImpl implements SearchRecordDao {
	private SessionFactory sessionFactory;

	@Override
	public void save(SearchRecord searchRecord) {
		sessionFactory.getCurrentSession().save(searchRecord);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchRecord> listAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from SearchRecord")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SearchRecord> listTopTen() {
		return sessionFactory.getCurrentSession()
				.createQuery("from SearchRecord order by counter desc")
				.setMaxResults(10)
				.list();
	}

	@Override
	public SearchRecord getByTitle(String title) {
		return (SearchRecord) sessionFactory.getCurrentSession()
				.createQuery("from SearchRecord as searchRecord where searchRecord.title=?")
				.setString(0, title)
				.uniqueResult();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void update(SearchRecord searchRecord) {
		sessionFactory.getCurrentSession().update(searchRecord);
	}

}
