package com.lib.dao;

import java.util.List;

import com.lib.domain.Category;

public interface CategoryDao {
	public Category getById(int id);
	public Category getByName(String name);
	public void update(Category category);
	public void delete(int id);
	public void save(Category category);
	public List<Category> listAll();
}
