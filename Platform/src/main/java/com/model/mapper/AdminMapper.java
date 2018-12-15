package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Admin;
import com.model.Student;

public class AdminMapper {

	public Admin getAdmin(ResultSet resultSet) {
		Admin admin = new Admin();
		
		try {
			admin.setCnp(resultSet.getString("cnp"));
			admin.setName(resultSet.getString("name"));
			admin.setSurname(resultSet.getString("surname"));
			admin.setPassword(resultSet.getString("pass"));
			admin.setExternalEmail(resultSet.getString("external_email"));
			admin.setInternalEmail(resultSet.getString("internal_email"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return admin;
	}

}
