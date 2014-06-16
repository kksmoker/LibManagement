package com.lib.dao;
import java.util.List;
import com.lib.domain.User;

public interface UserDao {
	public User getById(int uid);
	public User getByName(int name);
	public User getByEmail(String email);
	public void update(User user);
	public void save(User user);
	public void delete(int id);
	public List<User> listAll();
}
