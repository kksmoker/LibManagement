package com.lib.test.dao;

import java.util.Calendar;
import java.util.Date;

import com.lib.dao.impl.UserDaoImpl;
import com.lib.domain.User;

public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 30);
		Date date30 = cal.getTime();
		System.out.println(date);
		System.out.println(date30);
	}

}
