package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Course;
import com.model.Teacher;
import com.model.User;
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
	public Teacher getTeacherFor(Course course) {

		String query = "SELECT * FROM teacher,course WHERE course_name=?";
		ResultSet resultSet = null;

		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, course.getTeacher().getCnp());
			resultSet = p.executeQuery();
			resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherMapper.getTeacher(resultSet);
	}

	@Override
	public List<Teacher> getAllTeachers() {

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

	@Override
	public void save(Teacher teacher) {
		String query = "INSERT INTO teacher(name, surname, cnp, external_email, internal_email, password) VALUES(?, ?, ?, ?, ?, ?)";
		String userQuery = "INSERT INTO users(name, surname, userCNP, role) VALUES(?,?,?, 'teacher')";

		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, teacher.getName());
			p.setString(2, teacher.getSurname());
			p.setString(3, teacher.getCnp());
			p.setString(4, teacher.getExternalEmail());
			p.setString(5, teacher.getInternalEmail());
			p.setString(6, teacher.getPassword());

			p.executeUpdate();
			p = conn.prepareStatement(userQuery);
			p.setString(1, teacher.getName());
			p.setString(2, teacher.getSurname());
			p.setString(3, teacher.getCnp());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User selectedUser) {
		String query = "DELETE FROM teacher WHERE CNP=? ";

		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, selectedUser.getCnp());

			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
