package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.User;
import com.model.dao.UserDAO;
import com.model.mapper.UserMapper;

public class UserDAOImpl implements UserDAO {
	private Connection conn;
	private UserMapper userMapper;

	public UserDAOImpl(UserMapper userMapper, Connection conn) {
		super();
		this.conn = conn;
		this.userMapper = userMapper;
	}

	@Override
	public void save(User user) {

		String query = "INSERT INTO users(name, surname, userCNP, role)" + " VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, user.getName());
			p.setString(2, user.getSurname());
			p.setString(3, user.getCnp());
			p.setString(4, user.getRole());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User selectedUser) {
		String query = "DELETE FROM users WHERE userCNP=? ";

		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, selectedUser.getCnp());

			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {
		String query = "SELECT * FROM users";
		ResultSet resultSet = null;

		try {
			PreparedStatement p = conn.prepareStatement(query);

			resultSet = p.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userMapper.getAllUsers(resultSet);

	}
	
	@Override
	public User getUser(String cnp) {
		String query = "SELECT * FROM users WHERE userCNP=? ";
		ResultSet resultSet = null;

		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, cnp);
			resultSet = p.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		List<User> users = userMapper.getAllUsers(resultSet);
		if(users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
		
	}

	@Override
	public List<User> getUsers(String searchString) {
		String query = "SELECT * FROM users WHERE userCNP LIKE ? OR name LIKE ? OR surname LIKE ? OR role LIKE ?";
		ResultSet resultSet = null;

		try {
			PreparedStatement p = conn.prepareStatement(query);
		    p.setString(1, "%" + searchString + "%");
            p.setString(2, "%" + searchString + "%");
            p.setString(3, "%" + searchString + "%");
            p.setString(4, "%" + searchString + "%");
			resultSet = p.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userMapper.getAllUsers(resultSet);
	}

}
