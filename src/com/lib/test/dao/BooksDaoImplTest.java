package com.lib.test.dao;

import static org.junit.Assert.*;

import java.awt.print.Book;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.dao.BooksDao;
import com.lib.dao.PositionDao;
import com.lib.domain.Books;
import com.lib.domain.Category;
import com.lib.domain.Position;

public class BooksDaoImplTest {
	private static BooksDao booksDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			booksDao = (BooksDao) actionContext
					.getBean("booksDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		Books book = booksDao.getById(1);
		System.out.println(book.getName());
	}

	@Test
	public void testGetByBarcode() {
		Books book = booksDao.getByBarcode("009-00044");
		System.out.println(book.getName());
	}

	@Test
	public void testUpdate() {
		Books book = booksDao.getById(1);
		book.setSurplus(5);
		booksDao.update(book);
	}

	@Test
	public void testDelete() {
		booksDao.delete(8);
	}

	@Test
	public void testSave() {
		Books book = new Books();
		book.setAmount(5);
		book.setSurplus(5);
		book.setAuthor("毛泽东");
		Category category = new Category();
		category.setId(9);
		category.setName("马克思主义、列宁主义、毛泽东思想、邓小平理论");
		book.setCategory(category);
		Position position = new Position();
		position.setId(1);
		position.setFloor("二层");
		book.setPosition(position);
		book.setEnterdate(new Date());
		book.setPress("党中央出版社");
		book.setPrice(0.25f);
		book.setPubdate(new Date());
		book.setIsbn("978-7-303-05148-8");
		for (int i = 1; i < 6; i++) {
			book.setName("<<毛泽东选集" + i + ">>");
			book.setBarcode("009-000" + i + 4);
			booksDao.save(book);
		}
	}

	@Test
	public void testSearchByPress() {
		List<Books> list = booksDao.searchByPress("党");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Books books = (Books) iterator.next();
			System.out.println(books.getName() + "\t" + books.getPress());
		}
	}

	@Test
	public void testSearchByName() {
		List<Books> list = booksDao.searchByName("选");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Books books = (Books) iterator.next();
			System.out.println(books.getName() + "\t" + books.getPress());
		}
	}

}
