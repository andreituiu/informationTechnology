package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Teacher;
import com.model.dao.TeacherDAO;
import com.model.mapper.TeacherMapper;

import java.util.List;


public class TeacherDAOImpl implements TeacherDAO {
	private Connection conn;
	private TeacherMapper teacherMapper; 
	private Teacher teacher;

	public TeacherDAOImpl(TeacherMapper teacherMapper, Connection conn) {
		super();
		this.teacherMapper = teacherMapper;
		this.conn = conn;
	}

	@Override
	public Teacher getTeacher(String cnp) {
		String query = "SELECT * FROM teacher WHERE cnp=?";
		ResultSet resultSet = null;
		
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, cnp);
			resultSet = p.executeQuery();
			resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherMapper.getTeacher(resultSet);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM teacher";
		ResultSet resultSet = null;
		
		try {
			PreparedStatement p = conn.prepareStatement(query);
			
			resultSet = p.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherMapper.getAllTeachers(resultSet);

	}
	
	

	

}
