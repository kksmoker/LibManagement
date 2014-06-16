package com.lib.service;

import java.util.List;
import com.lib.domain.Books;
import com.lib.domain.BorrowRecord;

public interface BooksService {
	public int putInStorage(Books books);
	public void putOutStorage(int id);
	public int borrowBooks(String barcode, int uid);
	public int returnBooks(String barcode, int uid);
	public int renewBooks(int borrid, int uid);
	public int update(Books books);
	public Books  getByBarcode(String barcode);
	public Books getById(int id);
	public List<Books> searchByName(String name);
	public List<Books> searchByPress(String press);
	public List<BorrowRecord> listUnreturn(int uid);
	public List<BorrowRecord> listPersonalRecord(int uid);
	public Boolean hasOverdue(int uid);
}
