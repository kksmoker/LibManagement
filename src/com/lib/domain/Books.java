package com.lib.domain;

import java.util.Date;

public class Books {
	private int id;
	private String barcode;
	private String name;
	private String author;
	private Category category;//所属分类
	private String isbn;
	private String press;//出版社
	private int amount;//入库总量
	private int surplus;//剩余量
	private Date pubdate;//出版日期
	private Date enterdate;//入库日期
	private float price;
	private Position position;//存放位置
	private int counter;//借阅次数
	public Books() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSurplus() {
		return surplus;
	}
	public void setSurplus(int surplus) {
		this.surplus = surplus;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Date getEnterdate() {
		return enterdate;
	}
	public void setEnterdate(Date enterdate) {
		this.enterdate = enterdate;
	}

}
