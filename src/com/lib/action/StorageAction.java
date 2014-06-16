package com.lib.action;

import java.util.Date;

import com.lib.domain.Books;
import com.lib.domain.Category;
import com.lib.domain.Position;
import com.lib.service.BooksService;
import com.lib.service.CategoryService;
import com.lib.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class StorageAction extends ActionSupport {
	private Books book;
	private Category category;
	private Position position;
	private int bid;
	private CategoryService categoryService;
	private PositionService positionService;
	private BooksService booksService;
	private int uid;
	private String barcode;

	public String toPutin() {
		ActionContext.getContext().put("categorys", categoryService.listAll());
		ActionContext.getContext().put("positions", positionService.listAll());
		return "putin";
	}

	public String putin() {
		ActionContext.getContext().put("categorys", categoryService.listAll());
		ActionContext.getContext().put("positions", positionService.listAll());
		book.setPosition(position);
		book.setCategory(category);
		book.setSurplus(book.getAmount());
		book.setEnterdate(new Date());
		if (booksService.putInStorage(book) == 1) {
			ActionContext.getContext().put("msg",
					"<span class='label label-success'>入库成功</span>");
			return "putin";
		} else {
			ActionContext.getContext().put("msg",
					"<span class='label label-important'>条形码重复,请重试</span>");
			return "putin";
		}
	}

	public String toEdit() {
		ActionContext.getContext().put("book", booksService.getById(bid));
		return "toedit";
	}

	public String edit() {
		book.setPosition(position);
		book.setCategory(category);
		book.setSurplus(book.getAmount());
		book.setEnterdate(new Date());
		if (booksService.update(book) == 1) {
			return "search";
		} else {
			ActionContext.getContext().put("book", book);
			ActionContext.getContext().put("msg",
					"<span class='label label-important'>条形码重复,请重试</span>");
			return "toedit";
		}
	}

	/**
	 * 1: 借书成功; 2: 已借图书数量超过最大限制[每个人最多可借7本图书]; 3: 有超期未还的图书; 4: 条形码不存在; 5: 用户名不存在;
	 * 6: 图书已借完;
	 */
	public String borrow() {
		int result = booksService.borrowBooks(barcode, uid);
		String msg = null;
		switch (result) {
		case 1:
			msg = "<span class='label label-success'>借书成功</span>";
			break;
		case 2:
			msg = "<span class='label label-important'>该读者已借图书数量超过最大限制</span>";
			break;
		case 3:
			msg = "<span class='label label-important'>该读者有超期未还的图书</span>";
			break;
		case 4:
			msg = "<span class='label label-important'>条形码不存在</span>";
			break;
		case 5:
			msg = "<span class='label label-important'>用户名不存在</span>";
			break;
		case 6:
			msg = "<span class='label label-important'>图书已借完</span>";
			break;
		}
		ActionContext.getContext().put("msg", msg);
		return "borrow";
	}
	
	public String retn() {
		String msg = null;
		if (booksService.returnBooks(barcode, uid) == 1) {
			msg = "<span class='label label-success'>借入成功</span>";
		} else {
			msg = "<span class='label label-important'>条形码或者读者编号有误,请重试</span>";
		}
		ActionContext.getContext().put("msg", msg);
		return "retn";
	}

	/**
	 * 图书出库,暂时不做,没考虑到已借的书有外键引用
	 */
	/*
	 * public String putout() { System.out.println(bid);
	 * booksService.putOutStorage(bid); return "search"; }
	 */

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

}
