package com.dt.dao;

import com.dt.model.User;

public interface UserDao {

	public boolean insertValues(User user);

	public User getUserByUserId(int userId);

	public User getUserByUsername(String username);

}
