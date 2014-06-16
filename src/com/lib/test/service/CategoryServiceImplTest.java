package com.lib.test.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.domain.Books;
import com.lib.domain.Category;
import com.lib.service.CategoryService;
import com.lib.service.UserService;

public class CategoryServiceImplTest {
	private static CategoryService categoryService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			categoryService = (CategoryService) actionContext.getBean("categoryService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		Category category = new Category();
		category.setName("测试");
		System.out.println(categoryService.save(category));
	}

	@Test
	public void testDelete() {
		categoryService.delete(12);
	}

	@Test
	public void testGetByName() {
		Category category = categoryService.getByName("文学");
		Set<Books> list = category.getBooks();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Books books = (Books) iterator.next();
			System.out.println(books.getId() + "\t" + books.getName());
		}
	}

	@Test
	public void testGetById() {
		Category category = categoryService.getById(1);
		Set<Books> list = category.getBooks();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Books books = (Books) iterator.next();
			System.out.println(books.getId() + "\t" + books.getName());
		}
	}

	@Test
	public void testListAll() {
		List list = categoryService.listAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			System.out.println(category.getName());
		}
	}

	@Test
	public void testUpdateName() {
		Category category = categoryService.getById(12);
		category.setName("文学");
		System.out.println(categoryService.updateName(category));
	}

}
