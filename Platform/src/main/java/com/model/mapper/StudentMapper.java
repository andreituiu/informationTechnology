package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;

public class StudentMapper {

	public List<Student> getList(ResultSet resultSet) {
		List<Student> students = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				students.add(getStudent(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students ;
	}

	public Student getStudent(ResultSet resultSet) {
		Student student = new Student();
		
		try {
			student.setCnp(resultSet.getString("cnp"));
			student.setName(resultSet.getString("name"));
			student.setSurname(resultSet.getString("surname"));
			student.setPassword(resultSet.getString("password"));
			student.setExternalEmail(resultSet.getString("external_email"));
			student.setInternalEmail(resultSet.getString("internal_email"));
			student.setSpecialization(resultSet.getString("specialization"));
			student.setStudyYear(resultSet.getInt("year"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}

}
