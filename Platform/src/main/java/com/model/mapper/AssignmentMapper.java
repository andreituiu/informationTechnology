package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.model.Assignment;

public class AssignmentMapper {

	public Assignment getAssignment(ResultSet resultSet) {
		Assignment assignment = new Assignment();
		
		Integer id = null;
		String name = null;
		Date deadline = null;
		try {
			id = resultSet.getInt("assignment_id");
			name = resultSet.getString("name");
			deadline = resultSet.getDate("deadline");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assignment.setId(id);
		assignment.setName(name);
		assignment.setDeadline(deadline);
		
		return assignment;
	}

}
