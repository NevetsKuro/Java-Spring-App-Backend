package com.Dao;

import com.model.User;

public interface UserDao {

	public void insertUser(User user);
	
	public User findUserByName(String name);
}
