package com.lib.test.service;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.domain.Position;
import com.lib.service.CategoryService;
import com.lib.service.PositionService;

public class PositionServiceImplTest {
	private static PositionService positionService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			positionService = (PositionService) actionContext.getBean("positionService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		Position position = new Position();
		position.setFloor("四层");
		System.out.println(positionService.save(position));
	}

	@Test
	public void testDelete() {
		positionService.delete(5);
	}

	@Test
	public void testGetByFloor() {
		Position position = positionService.getByFloor("三层");
		System.out.println(position.getId());
	}

	@Test
	public void testGetById() {
		Position position = positionService.getById(3);
		System.out.println(position.getFloor());
	}

	@Test
	public void testListAll() {
		List<Position> list = positionService.listAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Position position = (Position) iterator.next();
			System.out.println(position.getFloor());
		}
	}

	@Test
	public void testUpdateFloor() {
		Position position = positionService.getByFloor("报刊室");
		position.setFloor("二层");
		System.out.println(positionService.updateFloor(position));
	}

}
