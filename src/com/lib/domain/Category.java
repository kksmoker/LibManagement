package com.lib.domain;

import java.util.Set;

public class Category {
	private int id;
	private String name;
	private Set<Books> books;
	public Category() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}

}
