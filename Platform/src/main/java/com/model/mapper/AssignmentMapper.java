package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Assignment;

public class AssignmentMapper {

	public Assignment getAssignment(ResultSet resultSet) {
		Assignment assignment = new Assignment();
		
		Integer id = null;
		String name = null;
		Date deadline = null;
		try {
			id = resultSet.getInt("id");
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

	public List<Assignment> getList(ResultSet resultSet) {
		List<Assignment> assignments = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				assignments.add(getAssignment(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return assignments;
	}

}
