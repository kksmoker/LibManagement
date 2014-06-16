package com.lib.domain;

import java.util.Date;

public class BorrowRecord {
	private int id;
	private int uid;
	private Books books;
	private Date borrdate;//借书日期
	private Date retndate;//应还日期
	private int isadd;//是否续借
	private Date realdate;//实际还书日期
	public BorrowRecord() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Date getBorrdate() {
		return borrdate;
	}
	public void setBorrdate(Date borrdate) {
		this.borrdate = borrdate;
	}
	public int getIsadd() {
		return isadd;
	}
	public void setIsadd(int isadd) {
		this.isadd = isadd;
	}
	public Date getRealdate() {
		return realdate;
	}
	public void setRealdate(Date realdate) {
		this.realdate = realdate;
	}
	public Date getRetndate() {
		return retndate;
	}
	public void setRetndate(Date retndate) {
		this.retndate = retndate;
	}

}
