package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.dao.AssignmentDAO;
import com.model.mapper.AssignmentMapper;
import com.model.mapper.StudentAssignmentMapper;

public class AssignmentDAOImpl implements AssignmentDAO {

    private StudentAssignmentMapper studentAssignmentsMapper;
	private Connection conn;
	private AssignmentMapper assignmentsMapper;
	
	

	
	public AssignmentDAOImpl(AssignmentMapper assignmentsMapper, StudentAssignmentMapper studentAssignmentsMapper,
			Connection conn) {
		super();
		this.assignmentsMapper = assignmentsMapper;
		this.studentAssignmentsMapper = studentAssignmentsMapper;
		this.conn = conn;
	}



	@Override
    public List<StudentAssignment> getAllAssignmentsFor(Course course, Student student) {
		
        String query = "SELECT * FROM assignment join student_assignment on assignment.id=student_assignment.assignment_id WHERE assignment.course_name = ? and student_assignment.student_id=?";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, course.getName());
            p.setString(2, student.getCnp());
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentAssignmentsMapper.getList(resultSet);
    }



	@Override
	public List<Assignment> getAssignmentsFor(Course course) {
		
		String query = "SELECT * FROM assignment WHERE course_name=?";
		ResultSet resultSet = null;
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, course.getName());
			resultSet = p.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return assignmentsMapper.getList(resultSet);
	}



	@Override
	public void save(StudentAssignment studentAssignment) {
		String query = "INSERT INTO student_assignment(student_id, assignment_id, lastUpdate, grade) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE lastUpdate=?, grade=?";
		Date sqlDate = null;
		if(studentAssignment.getLastUpdate() != null) {
			sqlDate = new java.sql.Date(studentAssignment.getLastUpdate().getTime());
		}
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, studentAssignment.getStudentCnp());
			p.setInt(2, studentAssignment.getAssignment().getId());
			p.setDate(3, sqlDate);
			p.setDouble(4, studentAssignment.getGrade());
			p.setDate(5, sqlDate);
			p.setDouble(6, studentAssignment.getGrade());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public StudentAssignment getStudentAssignment(Student student, Assignment assignment) {
		String query = "SELECT * FROM student_assignment WHERE assignment_id=? AND student_id=?";
		ResultSet resultSet = null;
		
		if(student == null || assignment == null) {
			StudentAssignment studentAssignment = new StudentAssignment();
			studentAssignment.setAssignment(new Assignment());
            return studentAssignment;
		}
		 
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setInt(1, assignment.getId());
			p.setString(2, student.getCnp());
			resultSet = p.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		StudentAssignment studentAssignment = studentAssignmentsMapper.getStudentAssignment(resultSet);
		studentAssignment.setStudentCnp(student.getCnp());
		studentAssignment.setAssignment(assignment);
		
		return studentAssignment;
	}



	@Override
	public void save(Assignment assignment) {
		String query = "INSERT INTO assignment(course_name, name, deadline) VALUES(?, ?, ?)";
		Date sqlDate = null;
		if(assignment.getDeadline() != null) {
			sqlDate = new java.sql.Date(assignment.getDeadline().getTime());
		}
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, assignment.getCourseName());
			p.setString(2, assignment.getName());
			p.setDate(3, sqlDate);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
