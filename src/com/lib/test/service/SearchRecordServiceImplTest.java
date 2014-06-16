package com.lib.test.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lib.domain.SearchRecord;
import com.lib.service.SearchRecordService;

public class SearchRecordServiceImplTest {
	private static SearchRecordService searchRecordService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			searchRecordService = (SearchRecordService) actionContext.getBean("searchRecordService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		for (int i = 0; i < 4; i++) {
			SearchRecord searchRecord = new SearchRecord();
			searchRecord.setTitle("西游记");
			searchRecordService.save(searchRecord);
		}
	}

	@Test
	public void testListAll() {
		List<SearchRecord> list = searchRecordService.listAll();
		for (SearchRecord searchRecord : list) {
			System.out.println(searchRecord.getTitle() + "\t" + searchRecord.getCounter());
		}
	}

	@Test
	public void testListTopTen() {
		List<SearchRecord> list = searchRecordService.listTopTen();
		for (SearchRecord searchRecord : list) {
			System.out.println(searchRecord.getTitle() + "\t" + searchRecord.getCounter());
		}
	}

}
