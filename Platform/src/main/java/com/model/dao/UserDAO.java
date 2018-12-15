package com.model.dao;

import java.util.List;

import com.model.User;

public interface UserDAO {

	void save(User user);

	void deleteUser(User selectedUser);

	List<User> getAllUsers();

	User getUser(String cnp);

	List<User> getUsers(String searchString);

}
