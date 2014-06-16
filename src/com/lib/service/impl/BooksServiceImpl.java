package com.lib.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.lib.dao.BooksDao;
import com.lib.dao.BorrowRecordDao;
import com.lib.dao.UserDao;
import com.lib.domain.Books;
import com.lib.domain.BorrowRecord;
import com.lib.domain.SearchRecord;
import com.lib.domain.User;
import com.lib.service.BooksService;
import com.lib.service.SearchRecordService;

public class BooksServiceImpl implements BooksService {
	private BooksDao booksDao;
	private BorrowRecordDao borrowRecordDao;
	private UserDao userDao;
	private SearchRecordService searchRecordService;
	/**
	 * 新书入库方法 返回值: 1: 入库成功; 2: 条形码重复;
	 */
	@Override
	public int putInStorage(Books books) {
		Books b = booksDao.getByBarcode(books.getBarcode());
		if (b == null) {
			booksDao.save(books);
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public void putOutStorage(int id) {
		booksDao.delete(id);
	}

	/**
	 * 借书方法 返回值: 1: 借书成功; 2: 已借图书数量超过最大限制[每个人最多可借7本图书]; 3: 有超期未还的图书; 4: 条形码不存在;
	 * 5: 用户名不存在; 6: 图书已借完;
	 */
	@Override
	public int borrowBooks(String barcode, int uid) {
		User user = userDao.getByName(uid);
		if (user == null) {
			return 5;
		} else if (borrowRecordDao.hasOverdue(user.getId())) {
			return 3;
		} else if (borrowRecordDao.listUnreturn(user.getId()).size() > 7) {
			return 2;
		} else {
			Books books = booksDao.getByBarcode(barcode);
			if (books == null) {
				return 4;
			} else if (books.getSurplus() <= 0) {
				return 6;
			} else {
				// 该图书库中库存量减一
				books.setSurplus(books.getSurplus() - 1);
				booksDao.update(books);
				// 新建借书记录
				BorrowRecord borrowRecord = new BorrowRecord();
				Date borrdate = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(borrdate);
				cal.set(Calendar.DAY_OF_MONTH,
						cal.get(Calendar.DAY_OF_MONTH) + 30);
				Date retndate = cal.getTime();
				borrowRecord.setBorrdate(borrdate);
				borrowRecord.setRetndate(retndate);
				borrowRecord.setUid(user.getId());
				borrowRecord.setBooks(books);
				borrowRecordDao.save(borrowRecord);
				return 1;
			}
		}
	}

	/**
	 * 还书方法 返回值: 1: 还书成功; 2: 数据有误,请查证该书是否该人所借;
	 */
	@Override
	public int returnBooks(String barcode, int uid) {
		User user = userDao.getByName(uid);
		if (user == null) {
			return 2;
		}
		List<BorrowRecord> records = borrowRecordDao.listUnreturn(userDao.getByName(uid).getId());
		BorrowRecord record = null;
		if (barcode == null || uid == 0 || records == null) {
			return 2;
		}
		for (BorrowRecord borrowRecord : records) {
			if (barcode.equals(borrowRecord.getBooks().getBarcode())) {
				record = borrowRecord;
			}
		}
		if (record == null) {
			return 2;
		} else {
			record.setRealdate(new Date());
			borrowRecordDao.update(record);
			return 1;
		}
	}

	/**
	 * 续借图书方法 返回值: 1:续借成功; 2:本书超过最大续借期限[最多续借一次,每次30天]; 3: 有到期未还的图书,不得续借;
	 */
	@Override
	public int renewBooks(int borrid, int uid) {
		if (borrowRecordDao.hasOverdue(uid)) {
			return 3;
		} else {
			BorrowRecord borrowRecord = borrowRecordDao.getById(borrid);
			if (borrowRecord.getIsadd() == 1) {
				return 2;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.setTime(borrowRecord.getRetndate());
				cal.set(Calendar.DAY_OF_MONTH,
						cal.get(Calendar.DAY_OF_MONTH) + 30);
				Date retndate = cal.getTime();
				borrowRecord.setRetndate(retndate);
				borrowRecord.setIsadd(1);
				borrowRecordDao.update(borrowRecord);
				return 1;
			}
		}
	}

	@Override
	public Books getByBarcode(String barcode) {
		return booksDao.getByBarcode(barcode);
	}

	@Override
	public Books getById(int id) {
		return booksDao.getById(id);
	}

	@Override
	public List<Books> searchByName(String name) {
		SearchRecord searchRecord = new SearchRecord();
		searchRecord.setTitle(name);
		searchRecordService.save(searchRecord);
		return booksDao.searchByName(name);
	}

	@Override
	public List<Books> searchByPress(String press) {
		SearchRecord searchRecord = new SearchRecord();
		searchRecord.setTitle(press);
		searchRecordService.save(searchRecord);
		return booksDao.searchByPress(press);
	}

	@Override
	public List<BorrowRecord> listUnreturn(int uid) {
		return borrowRecordDao.listUnreturn(uid);
	}

	@Override
	public List<BorrowRecord> listPersonalRecord(int uid) {
		return borrowRecordDao.listPersonalRecord(uid);
	}

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	public void setBorrowRecordDao(BorrowRecordDao borrowRecordDao) {
		this.borrowRecordDao = borrowRecordDao;
	}

	/**
	 * 图书信息修改方法 返回值: 1: 修改成功; 2: 条形码重复,修改失败;
	 */
	@Override
	public int update(Books books) {
		Books book = booksDao.getByBarcode(books.getBarcode());
		if (book == null) {
			booksDao.update(books);
			return 1;
		} else if (books.getId() == book.getId()) {
			booksDao.update(books);
			return 1;
		} else {
			return 2;
		}
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Boolean hasOverdue(int uid) {
		return borrowRecordDao.hasOverdue(uid);
	}

	public void setSearchRecordService(SearchRecordService searchRecordService) {
		this.searchRecordService = searchRecordService;
	}

}
