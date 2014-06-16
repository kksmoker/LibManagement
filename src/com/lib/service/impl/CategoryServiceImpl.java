package com.lib.service.impl;

import java.util.List;
import com.lib.dao.CategoryDao;
import com.lib.domain.Category;
import com.lib.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;
	
	/**
	 * 添加新分类方法
	 * 返回值: 1: 添加成功; 2: 分类已经存在,添加失败;
	 */
	@Override
	public int save(Category category) {
		Category c = categoryDao.getByName(category.getName());
		if (c == null) {
			categoryDao.save(category);
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public Category getByName(String name) {
		return categoryDao.getByName(name);
	}

	@Override
	public Category getById(int id) {
		return categoryDao.getById(id);
	}

	@Override
	public List<Category> listAll() {
		return categoryDao.listAll();
	}


	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 更新分类名称
	 * 返回值: 1: 更新成功; 2: 该分类名已经存在;
	 */
	@Override
	public int updateName(Category category) {
		Category c = categoryDao.getByName(category.getName());
		if (c == null) {
			categoryDao.update(category);
			return 1;
		} else if (c.getId() == category.getId()) {
			categoryDao.update(category);
			return 1;
		} else {
			return 2;
		}
	}

}
