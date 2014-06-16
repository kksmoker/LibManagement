package com.lib.service;

import java.util.List;
import com.lib.domain.Position;

public interface PositionService {
	public int save(Position position);
	public void delete(int id);
	public Position getByFloor(String floor);
	public Position getById(int id);
	public List<Position> listAll();
	public int updateFloor(Position position);
}
