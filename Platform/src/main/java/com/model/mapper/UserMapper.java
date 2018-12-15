package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;



public class UserMapper {
	
	
	public List<User> getAllUsers(ResultSet resultSet) {

		List<User> users = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				users.add(getUser(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return users;
		}
		
		return users ;
	}

	private User getUser(ResultSet resultSet) {
		
		 User user = new User();
			
	        try {
	            user.setCnp(resultSet.getString("userCNP"));
	            user.setName(resultSet.getString("name"));
	            user.setSurname(resultSet.getString("surname"));
	            user.setRole(resultSet.getString("role"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return user;
		
	}
}
