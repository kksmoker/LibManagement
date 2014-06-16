package com.lib.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.domain.SearchRecord;
import com.lib.dao.SearchRecordDao;

public class SearchRecordImplTest {
	private static SearchRecordDao searchRecordDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			searchRecordDao = (SearchRecordDao) actionContext.getBean("searchRecordDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		SearchRecord searchRecord = new SearchRecord();
		String[] titles = {"数据结构", "厚黑学", "性爱本色"};
		for (String string : titles) {
			searchRecord.setTitle(string);
			searchRecordDao.save(searchRecord);
		}
	}

	@Test
	public void testListAll() {
		List<SearchRecord> list = searchRecordDao.listAll();
		for (SearchRecord searchRecord : list) {
			System.out.println(searchRecord.getTitle() + "\t" + searchRecord.getId());
		}
	}

	@Test
	public void testListTopTen() {
		List<SearchRecord> list = searchRecordDao.listTopTen();
		for (SearchRecord searchRecord : list) {
			System.out.println(searchRecord.getTitle() + "\t" + searchRecord.getCounter());
		}
	}

	@Test
	public void testGetByTitle() {
		SearchRecord searchRecord = searchRecordDao.getByTitle("java");
		System.out.println(searchRecord.getTitle());
	}
	
	@Test
	public void testUpdate() {
		SearchRecord searchRecord = searchRecordDao.getByTitle("java");
		searchRecord.setCounter(searchRecord.getCounter() + 1);
		searchRecordDao.update(searchRecord);
	}

}
