package com.lib.service.impl;

import java.util.List;
import com.lib.dao.PositionDao;
import com.lib.domain.Position;
import com.lib.service.PositionService;

public class PositionServiceImpl implements PositionService {
	private PositionDao positionDao;

	/**
	 * 添加新地点方法
	 * 返回值: 1: 添加成功; 2: 地点已经存在;
	 */
	@Override
	public int save(Position position) {
		Position p = positionDao.getByFloor(position.getFloor());
		if (p == null) {
			positionDao.save(position);
			return 1;
		} else if (p.getId() == position.getId()) {
			positionDao.save(position);
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public void delete(int id) {
		positionDao.delete(id);
	}

	@Override
	public Position getByFloor(String floor) {
		return positionDao.getByFloor(floor);
	}

	@Override
	public Position getById(int id) {
		return positionDao.getById(id);
	}

	@Override
	public List<Position> listAll() {
		return positionDao.listAll();
	}

	/**
	 * 更新地点楼层
	 * 返回值: 1: 更新成功; 2: 该分地点已经存在;
	 */
	@Override
	public int updateFloor(Position position) {
		Position p = positionDao.getByFloor(position.getFloor());
		if (p == null) {
			positionDao.update(position);
			return 1;
		} else if (p.getId() == position.getId()) {
			positionDao.update(position);
			return 1;
		} else {
			return 2;
		}
	}

	public void setPositionDao(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

}
