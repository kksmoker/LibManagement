package com.lib.test.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lib.dao.CategoryDao;
import com.lib.dao.PositionDao;
import com.lib.domain.Position;

public class PositionDaoImplTest {
	private static PositionDao positionDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext actionContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			positionDao = (PositionDao) actionContext
					.getBean("positionDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetById() {
		Position position = positionDao.getById(2);
		System.out.println(position.getFloor());
	}
	
	@Test
	public void testGetByFloor() {
		Position position = positionDao.getByFloor("d二层");
		System.out.println(position == null);
	}

	@Test
	public void testSave() {
		Position position = new Position();
		String[] floors = {"一层", "二层", "三层", "四层", "五层"};
		for (int i = 0; i < floors.length; i++) {
			position.setFloor(floors[i]);
			positionDao.save(position);
		}
	}

	@Test
	public void testUdpate() {
		Position position = positionDao.getById(4);
		position.setFloor("期刊室");
		positionDao.update(position);
	}

	@Test
	public void testDelete() {
		positionDao.delete(5);
	}

	@Test
	public void testListAll() {
		List<Position> list = positionDao.listAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Position position = (Position) iterator.next();
			System.out.println(position.getFloor() + "\t" + position.getId());
		}
	}

}
