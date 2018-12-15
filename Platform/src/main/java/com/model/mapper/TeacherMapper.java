package com.model.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Teacher;

public class TeacherMapper {

    public Teacher getTeacher(ResultSet resultSet) {
        Teacher teacher = new Teacher();
		
        try {
            teacher.setCnp(resultSet.getString("cnp"));
            teacher.setName(resultSet.getString("name"));
            teacher.setSurname(resultSet.getString("surname"));
            teacher.setPassword(resultSet.getString("password"));
            teacher.setExternalEmail(resultSet.getString("external_email"));
            teacher.setInternalEmail(resultSet.getString("internal_email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return teacher;
    }

	public List<Teacher> getAllTeachers(ResultSet resultSet) {

		List<Teacher> teachers = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				teachers.add(getTeacher(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teachers ;
	}
		
}


