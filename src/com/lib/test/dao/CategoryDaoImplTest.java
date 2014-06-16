package com.lib.test.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.dao.CategoryDao;
import com.lib.dao.UserDao;
import com.lib.domain.Books;
import com.lib.domain.Category;

public class CategoryDaoImplTest {
	private static CategoryDao categoryDao = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			categoryDao = (CategoryDao) actionContext
					.getBean("categoryDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		Category category = categoryDao.getById(32);
		//Set<Books> books = category.getBooks();
		/*for (Iterator iterator = books.iterator(); iterator.hasNext();) {
			Books books2 = (Books) iterator.next();
			if (books2 == null) {
				System.out.println("空的");
			} else {
				System.out.println(books2.getName());
			}
		}*/
		System.out.println(category == null);
	}
	
	@Test
	public void testGetByName() {
		Category category = categoryDao.getByName("文学");
		System.out.println(category == null);
	}

	@Test
	public void testUpdate() {
		Category category = categoryDao.getById(9);
		category.setName("文学");
		categoryDao.update(category);
	}

	@Test
	public void testDelete() {
		categoryDao.delete(12);
	}

	@Test
	public void testSave() {
		Category category = new Category();
		String[] names = {"马克思主义、列宁主义、毛泽东思想、邓小平理论", "哲学、宗教",
				"社会科学总论 ", "政治、法律 ", "军事 ", "经济", "文化、科学、教育、体育 ",
				"语言、文字", "文学", "艺术", "历史、地理", "自然科学总论"};
		for (int i = 0; i < names.length; i++) {
			category.setName(names[i]);
			categoryDao.save(category);
		}
	}

	@Test
	public void testListAll() {
		List<Category> list = categoryDao.listAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			System.out.println(category.getName());
		}
	}

}
