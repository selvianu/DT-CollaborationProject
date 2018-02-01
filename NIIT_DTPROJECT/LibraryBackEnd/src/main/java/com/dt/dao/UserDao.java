package com.dt.dao;

import java.util.List;

import com.dt.model.User;

public interface UserDao {
	public boolean addUser(User user);

	public List<User> retrieveUser();

	public boolean deleteUser(User user);

	public User getUser(String username);

	public boolean updateUser(User user);

}
