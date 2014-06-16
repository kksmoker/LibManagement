package com.lib.service;

import com.lib.domain.User;

public interface UserService {
	public int login(int name, String password);
	public int regist(User user);
	public void update(User user);
	public void delete(int id);
	public User getByName(int name);
	public int updateEmail(User user);
}
