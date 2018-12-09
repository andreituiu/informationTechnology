package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Teacher;

public class TeacherMapper {

    public Teacher getTeacher(ResultSet resultSet) {
        Teacher teacher = new Teacher();
        
        try {
            teacher.setCnp(resultSet.getString("cnp"));
            teacher.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return teacher;
    }

}
