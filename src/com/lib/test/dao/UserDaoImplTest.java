package com.lib.test.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lib.dao.UserDao;
import com.lib.dao.impl.UserDaoImpl;
import com.lib.domain.User;

public class UserDaoImplTest {
	private static UserDao userDao = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			userDao = (UserDao) actionContext
					.getBean("userDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUserDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		User user = userDao.getById(2);
		if (user == null) {
			System.out.println("null");
		} else {
			System.out.println("not null");
		}
	}
	@Test
	public void testGetByName() {
		int name = 20112859;
		User user = userDao.getByName(name);
		System.out.println(user.getName() + "\t" + user.getId());
	}

	@Test
	public void testUpdate() {
		int name = 20112859;
		User user = userDao.getByName(name);
		user.setEmail("284135112@qq.com");
		userDao.update(user);
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setName(20112858);
		user.setPassword("123456");
		System.out.println(user.getName());
		userDao.save(user);
	}

	@Test
	public void testDelete() {
		userDao.delete(6);
	}
	
	@Test 
	public void testListAll() {
		System.out.println(userDao.listAll().size());
	}

	public static void setUserDao(UserDao userDao) {
		UserDaoImplTest.userDao = userDao;
	}

}
