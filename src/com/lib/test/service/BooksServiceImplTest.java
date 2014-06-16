package com.lib.test.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.domain.Books;
import com.lib.domain.BorrowRecord;
import com.lib.domain.Category;
import com.lib.domain.Position;
import com.lib.service.BooksService;
import com.lib.service.SearchRecordService;

public class BooksServiceImplTest {
	private static BooksService booksService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			booksService = (BooksService) actionContext.getBean("booksService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPutInStorage() {
		Books book = new Books();
		book.setName("国防科技");
		book.setAmount(3);
		book.setSurplus(3);
		book.setAuthor("邓小毛");
		Category category = new Category();
		category.setId(5);
		category.setName("军事");
		book.setCategory(category);
		Position position = new Position();
		position.setId(3);
		position.setFloor("三层");
		book.setPosition(position);
		book.setEnterdate(new Date());
		book.setPress("电子科技出版社");
		book.setPrice(33.5f);
		book.setPubdate(new Date());
		book.setIsbn("978-7-303-05148-8");
		book.setBarcode("001-00044");
		System.out.println(booksService.putInStorage(book));
	}

	@Test
	public void testPutOutStorage() {
		booksService.putOutStorage(2);
	}

	@Test
	public void testBorrowBooks() {
		System.out.println(booksService.borrowBooks("009-00044", 2));
	}

	@Test
	public void testReturnBooks() {
		System.out.println(booksService.returnBooks("009-00044", 2));
	}

	@Test
	public void testRenewBooks() {
		System.out.println(booksService.renewBooks(6, 2));
	}

	@Test
	public void testGetByBarcode() {
		System.out.print(booksService.getByBarcode("009-00044").getAuthor());
	}

	@Test
	public void testGetById() {
		System.out.print(booksService.getById(2).getAuthor());
	}

	@Test
	public void testSearchByName() {
		List<Books> list = booksService.searchByName("选");
		for (Books book : list) {
			System.out.println(book.getId() + "\t" + book.getName());
		}
	}

	@Test
	public void testSearchByPress() {
		List<Books> list = booksService.searchByPress("党");
		for (Books book : list) {
			System.out.println(book.getId() + "\t" + book.getName());
		}
	}

	@Test
	public void testListUnreturn() {
		List<BorrowRecord> list = booksService.listUnreturn(1);
		for (BorrowRecord borrowRecord : list) {
			System.out.println(borrowRecord.getId() + "\t" + borrowRecord.getBooks().getName() + "\t" + borrowRecord.getBorrdate());
		}
	}

	@Test
	public void testListPersonalRecord() {
		List<BorrowRecord> list = booksService.listPersonalRecord(1);
		for (BorrowRecord borrowRecord : list) {
			System.out.println(borrowRecord.getId() + "\t" + borrowRecord.getUid() + "\t" + borrowRecord.getBooks().getName());
		}
	}

	@Test
	public void testUpdate() {
		Books books = booksService.getById(8);
		books.setAuthor("毛泽西");
		System.out.println(booksService.update(books));
	}
	
	@Test
	public void testHasOverdue() {
		System.out.println(booksService.hasOverdue(1));
	}

}
