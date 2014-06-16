package com.lib.dao;

import java.util.List;

import com.lib.domain.Books;

public interface BooksDao {
	public Books getById(int id);
	public Books getByBarcode(String barcode);
	public void update(Books books);
	public void delete(int id);
	public void save(Books books);
	public List<Books> searchByPress(String press);
	public List<Books> searchByName(String name);
}
