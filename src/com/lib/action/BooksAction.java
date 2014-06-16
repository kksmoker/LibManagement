package com.lib.action;

import java.util.List;

import com.lib.domain.BorrowRecord;
import com.lib.domain.User;
import com.lib.service.BooksService;
import com.lib.service.CategoryService;
import com.lib.service.PositionService;
import com.lib.service.SearchRecordService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BooksAction extends ActionSupport{
	private BooksService booksService;
	private int borrid;
	private String searchMethod;
	private String searchContent;
	private CategoryService categoryService;
	private SearchRecordService searchRecordService;
	private PositionService positionService;
	
	public String listUnreturn() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return "error";
		} else {
			List<BorrowRecord> records = booksService.listUnreturn(user.getId());
			ActionContext.getContext().put("hasOverdue", booksService.hasOverdue(user.getId()));
			ActionContext.getContext().put("records", records);
			return "success";
		}
	}
	
	public String renew() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return "error";
		} else {
			int result = booksService.renewBooks(borrid, user.getId());
			if (result == 1) {
				ActionContext.getContext().put("msg", this.getText("*续借成功"));
			} else if (result == 2) {
				ActionContext.getContext().put("msg", this.getText("*不可多次续借"));
			} else {
				ActionContext.getContext().put("msg", this.getText("*有超期未还书籍,不得续借!"));
			}
			return "success";
		}
	}
	
	public String history() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return "error";
		} else {
			ActionContext.getContext().put("history", booksService.listPersonalRecord(user.getId()));
			return "success";
		}
	}
	
	public String search() {
		ActionContext.getContext().put("topTen", searchRecordService.listTopTen());
		ActionContext.getContext().put("categorys", categoryService.listAll());
		if (searchMethod.equals("byName")) {
			ActionContext.getContext().put("results", booksService.searchByName(searchContent));
		} else if (searchMethod.equals("byCategory")) {
			ActionContext.getContext().put("results", categoryService.getByName(searchContent).getBooks());
		} else {
			ActionContext.getContext().put("results", booksService.searchByPress(searchContent));
		}
		return "success";
	}
	
	public String toSearch() {
		ActionContext.getContext().put("topTen", searchRecordService.listTopTen());
		ActionContext.getContext().put("categorys", categoryService.listAll());
		return "success";
	}
	
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	public int getBorrid() {
		return borrid;
	}

	public void setBorrid(int borrid) {
		this.borrid = borrid;
	}

	public String getSearchMethod() {
		return searchMethod;
	}

	public void setSearchMethod(String searchMethod) {
		this.searchMethod = searchMethod;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setSearchRecordService(SearchRecordService searchRecordService) {
		this.searchRecordService = searchRecordService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
}
