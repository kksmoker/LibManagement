package com.lib.dao;

import java.util.List;

import com.lib.domain.SearchRecord;

public interface SearchRecordDao {
	public void save(SearchRecord searchRecord);
	public List<SearchRecord> listAll();
	public List<SearchRecord> listTopTen();
	public SearchRecord getByTitle(String title);
	public void update(SearchRecord searchRecord);
}
