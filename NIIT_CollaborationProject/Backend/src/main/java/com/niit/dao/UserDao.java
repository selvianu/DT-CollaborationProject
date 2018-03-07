package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUserById(int userId);

	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(User user);

	boolean userExists(String name);

}
