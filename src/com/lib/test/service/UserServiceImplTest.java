package com.lib.test.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.dao.BooksDao;
import com.lib.dao.BorrowRecordDao;
import com.lib.domain.User;
import com.lib.service.UserService;

public class UserServiceImplTest {
	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			userService = (UserService) actionContext.getBean("userService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLogin() {
		System.out.println(userService.login(20112859, "123456"));
	}

	@Test
	public void testRegist() {
		User user = new User();
		user.setName(20110007);
		user.setPassword("123456");
		System.out.println(userService.regist(user));
	}

	@Test
	public void testUpdate() {
		User user = userService.getByName(20110007);
		user.setEmail("284135112@qq.com");
		userService.update(user);
	}

	@Test
	public void testDelete() {
		User user = userService.getByName(20110007);
		userService.delete(user.getId());
	}

	@Test
	public void testGetByName() {
		User user = userService.getByName(20110003);
		System.out.println(user == null);
	}

	@Test
	public void testUpdateEmail() {
		User user = userService.getByName(20110007);
		user.setEmail("55555512@qq.com");
		System.out.println(userService.updateEmail(user));
	}
}
