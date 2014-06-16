package com.lib.action;

import com.lib.domain.Category;
import com.lib.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CategoryAction extends ActionSupport {
	private Category category;
	private CategoryService categoryService;
	private int id;
	
	public String save() {
		String msg = null;
		if (categoryService.save(category) == 1) {
			msg = "<span class='label label-success'>添加成功</span>";
		} else {
			msg = "<span class='label label-important'>分类已经存在</span>";
		}
		ActionContext.getContext().put("msg", msg);
		return "success";
	}
	
	public String toEdit() {
		ActionContext.getContext().put("cate", categoryService.getById(id));
		return "cateedit";
	}
	
	public String update() {
		ActionContext.getContext().put("cate", categoryService.getById(category.getId()));
		if (categoryService.updateName(category) == 1) {
			ActionContext.getContext().put("msg", "<span class='label label-success'>修改成功</span>");
			return "success";
		} else {
			ActionContext.getContext().put("msg", "<span class='label label-important'>分类名已经存在</span>");
			return "cateedit";
		}
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
