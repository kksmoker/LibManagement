package com.lib.service.impl;

import java.util.List;

import com.lib.dao.SearchRecordDao;
import com.lib.domain.SearchRecord;
import com.lib.service.SearchRecordService;

public class SearchRecordServiceImpl implements SearchRecordService {
	private SearchRecordDao searchRecordDao;
	@Override
	public void save(SearchRecord searchRecord) {
		SearchRecord sRecord = searchRecordDao.getByTitle(searchRecord.getTitle());
		if (sRecord == null) {
			searchRecordDao.save(searchRecord);
		} else {
			sRecord.setCounter(sRecord.getCounter() + 1);
			searchRecordDao.update(sRecord);
		}
	}

	@Override
	public List<SearchRecord> listAll() {
		return searchRecordDao.listAll();
	}

	@Override
	public List<SearchRecord> listTopTen() {
		return searchRecordDao.listTopTen();
	}

	public void setSearchRecordDao(SearchRecordDao searchRecordDao) {
		this.searchRecordDao = searchRecordDao;
	}

}
