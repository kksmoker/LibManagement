package com.lib.service;

import java.util.List;

import com.lib.domain.Category;

public interface CategoryService {
	public int save(Category category);
	public void delete(int id);
	public Category getByName(String name);
	public Category getById(int id);
	public List<Category> listAll();
	public int updateName(Category category);
}
