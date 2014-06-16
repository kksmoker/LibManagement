package com.lib.dao;

import java.util.List;
import com.lib.domain.Position;

public interface PositionDao {
	public Position getById(int id);
	public Position getByFloor(String floor);
	public void save(Position position);
	public void update(Position position);
	public void delete(int id);
	public List<Position> listAll();
}
