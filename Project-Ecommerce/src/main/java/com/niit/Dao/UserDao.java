package com.niit.Dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {
	boolean saveUser(User user);
	boolean deleteUser(int id);
	boolean updateUser(User user);
	List<User> listalluser();
	List<User> getid(int id);
	public boolean isValidUser(String username, String password);
}
