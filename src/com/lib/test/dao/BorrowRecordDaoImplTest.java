package com.lib.test.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.dao.BooksDao;
import com.lib.dao.BorrowRecordDao;
import com.lib.domain.Books;
import com.lib.domain.BorrowRecord;

public class BorrowRecordDaoImplTest {
	private static BorrowRecordDao borrowRecordDao;
	private static BooksDao booksDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			borrowRecordDao = (BorrowRecordDao) actionContext
					.getBean("borrowRecordDao");
			booksDao = (BooksDao) actionContext
					.getBean("booksDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		BorrowRecord borrowRecord = new BorrowRecord();
		Books books = booksDao.getById(2);
		borrowRecord.setBooks(books);
		Date borrdate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(borrdate);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 30);
		Date retndate = cal.getTime();
		borrowRecord.setBorrdate(borrdate);
		borrowRecord.setRetndate(retndate);
		borrowRecord.setUid(1);
		borrowRecordDao.save(borrowRecord);
	}

	@Test
	public void testUpdate() {
		BorrowRecord borrowRecord = borrowRecordDao.getById(5);
		borrowRecord.setIsadd(1);
		borrowRecordDao.update(borrowRecord);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetById() {
		BorrowRecord borrowRecord = borrowRecordDao.getById(5);
		Books books = borrowRecord.getBooks();
		System.out.println(books.getName());
	}

	@Test
	public void testListPersonalRecord() {
		List<BorrowRecord> list = borrowRecordDao.listPersonalRecord(1);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BorrowRecord borrowRecord = (BorrowRecord) iterator.next();
			Books books = borrowRecord.getBooks();
			System.out.println(books.getName() + "\t" + borrowRecord.getBorrdate() 
					+ "\t" + borrowRecord.getRetndate());
		}
	}

	@Test
	public void testListUnreturn() {
		List<BorrowRecord> list = borrowRecordDao.listUnreturn(1);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			BorrowRecord borrowRecord = (BorrowRecord) iterator.next();
			System.out.println(borrowRecord.getBorrdate());
		}
	}

	@Test
	public void testHasOverdue() {
		System.out.println(borrowRecordDao.hasOverdue(1));
	}

}
