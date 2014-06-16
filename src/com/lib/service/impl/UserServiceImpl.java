package com.lib.service.impl;

import com.lib.dao.UserDao;
import com.lib.domain.User;
import com.lib.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	/**
	 * 登陆方法:
	 * 返回值: 1:登陆成功; 2: 用户名不存在; 3: 密码不正确;
	 * @see com.lib.service.UserService#login(int)
	 */
	@Override
	public int login(int name, String password) {
		User user = userDao.getByName(name);
		if (user == null) {
			return 2;
		} else if (password.equals(user.getPassword())) {
			return 1;
		} else {
			return 3;
		}
	}

	/**
	 * 注册用户方法
	 * 返回值: 1: 注册成功; 2: 用户名已经存在;
	 */
	@Override
	public int regist(User user) {
		User u = userDao.getByName(user.getName());
		if (u == null) {
			userDao.save(user);
			return 1;
		} else {
			return 2;
		}
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User getByName(int name) {
		return userDao.getByName(name);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 修改邮箱
	 * 返回值: 1: 修改成功; 2: 邮箱已经存在;
	 */
	@Override
	public int updateEmail(User user) {
		User u = userDao.getByEmail(user.getEmail());
		if (u == null) {
			userDao.update(user);
			return 1;
		} else if(u.getName() == user.getName()){
			userDao.update(user);
			return 1;
		} else {
			return 2;
		}
	}

}
