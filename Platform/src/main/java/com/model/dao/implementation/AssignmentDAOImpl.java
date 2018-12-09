package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.dao.AssignmentDAO;
import com.model.mapper.StudentAssignmentMapper;

public class AssignmentDAOImpl implements AssignmentDAO {

    private StudentAssignmentMapper studentAssignmentsMapper;
	private Connection conn;
	
	

	public AssignmentDAOImpl(StudentAssignmentMapper studentAssignmentsMapper, Connection conn) {
		super();
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

}
