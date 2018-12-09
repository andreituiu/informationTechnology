package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Assignment;
import com.model.StudentAssignment;

public class StudentAssignmentMapper {

	private AssignmentMapper assignmetMapper;
	
	

	public StudentAssignmentMapper(AssignmentMapper assignmetMapper) {
		super();
		this.assignmetMapper = assignmetMapper;
	}



	public List<StudentAssignment> getList(ResultSet resultSet) {
		List<StudentAssignment> studentAssignments = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				
				StudentAssignment studentAssignment = new StudentAssignment();
				
				Assignment assignment = assignmetMapper.getAssignment(resultSet);
				Double grade = null;
				Date lastUpdate = null;
				try {
					grade = resultSet.getDouble("grade");
					lastUpdate = resultSet.getDate("lastUpdate");
				} catch (SQLException e) {
					e.printStackTrace();
				}

				studentAssignment.setAssignment(assignment);
				studentAssignment.setGrade(grade);
				studentAssignment.setLastUpdate(lastUpdate);
				
				studentAssignments.add(studentAssignment);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentAssignments;
	}

}
