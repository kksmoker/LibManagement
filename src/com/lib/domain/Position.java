package com.lib.domain;

import java.util.Set;

public class Position {
	private int id;
	private String floor;
	private Set<Books> books;
	public Position() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}

}
