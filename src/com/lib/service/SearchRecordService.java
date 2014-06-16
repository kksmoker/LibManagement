package com.lib.service;

import java.util.List;

import com.lib.domain.SearchRecord;

public interface SearchRecordService {
	public void save(SearchRecord searchRecord);
	public List<SearchRecord> listAll();
	public List<SearchRecord> listTopTen();
}
