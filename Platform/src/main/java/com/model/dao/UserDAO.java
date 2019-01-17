package com.model.dao;

import java.util.List;

import com.model.User;

public interface UserDAO extends BaseDAO<User, String>{

	List<User> findAll();

	List<User> findContaining(String searchTxt);

}
