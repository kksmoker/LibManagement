package com.lib.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.lib.dao.BorrowRecordDao;
import com.lib.domain.BorrowRecord;

public class BorrowRecordDaoImpl implements BorrowRecordDao {
	private SessionFactory sessionFactory;

	@Override
	public void save(BorrowRecord borrowRecord) {
		sessionFactory.getCurrentSession().save(borrowRecord);
	}

	@Override
	public void update(BorrowRecord borrowRecord) {
		sessionFactory.getCurrentSession().update(borrowRecord);
	}

	@Override
	public BorrowRecord getById(int id) {
		return (BorrowRecord) sessionFactory.getCurrentSession()
				.get(BorrowRecord.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowRecord> listPersonalRecord(int uid) {
		return sessionFactory.getCurrentSession()
				.createQuery("from BorrowRecord as borrowRecord where borrowRecord.uid = ?")
				.setInteger(0, uid)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BorrowRecord> listUnreturn(int uid) {
		return sessionFactory.getCurrentSession()
				.createQuery("from BorrowRecord as borrowRecord where "
						+ "borrowRecord.uid = ? and borrowRecord.realdate is null")
				.setInteger(0, uid)
				.list();
	}

	@Override
	public Boolean hasOverdue(int uid) {
		BorrowRecord borrowRecord = (BorrowRecord) sessionFactory.getCurrentSession()
				.createQuery("from BorrowRecord as borrowRecord where "
						+ "borrowRecord.uid = ? and timestampdiff"
						+ "(day, borrowRecord.retndate, now()) > 30")
				.setInteger(0, uid)
				.uniqueResult();
		if (borrowRecord != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
