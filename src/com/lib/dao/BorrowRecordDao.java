package com.lib.dao;

import java.util.List;

import com.lib.domain.BorrowRecord;

public interface BorrowRecordDao {
	public void save(BorrowRecord borrowRecord);
	public void update(BorrowRecord borrowRecord);
	public BorrowRecord getById(int id);
	public List<BorrowRecord> listPersonalRecord(int uid);
	public List<BorrowRecord> listUnreturn(int uid);
	public Boolean hasOverdue(int uid);
}
