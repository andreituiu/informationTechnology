package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.model.Student;
import com.model.dao.StudentDAO;
import com.model.mapper.StudentMapper;

public class StudentDAOImpl implements StudentDAO {
    private StudentMapper studentMapper;
    private Connection conn;

    public StudentDAOImpl(StudentMapper studentMapper, Connection conn) {
        super();
        this.studentMapper = studentMapper;
        this.conn = conn;
    }

    @Override
    public Student getStudent(String cnp) {
        String query = "SELECT * FROM student WHERE cnp=?";
        ResultSet resultSet = null;

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, cnp);
            resultSet = p.executeQuery();
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentMapper.getStudent(resultSet);
    }

    @Override
    public List<Student> getWaitingStudents(Course course) {
        String query = "SELECT * FROM student join stud_pending_courses on student.cnp=stud_pending_courses.studentCNP WHERE courseName=?";
        ResultSet resultSet = null;

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, course.getName());
            resultSet = p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet == null) {
            return new ArrayList<>();
        }

        return studentMapper.getList(resultSet);
    }

    @Override
    public List<Student> getEnrolledStudents(Course course) {
        String query = "SELECT * FROM student join stud_enrolled_courses on student.cnp=stud_enrolled_courses.studentCNP WHERE courseName=?";
        ResultSet resultSet = null;

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, course.getName());
            resultSet = p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet == null) {
            return new ArrayList<>();
        }

        return studentMapper.getList(resultSet);
    }

    @Override
    public void enrolleToCourse(Student selectedStudent, Course course) {
        String removeFromPendingQuery = "DELETE FROM stud_pending_courses WHERE studentCNP=? AND courseName=?";
        String addToEnrolledCourseQuery = "INSERT INTO stud_enrolled_courses (studentCNP, courseName) VALUES (?,?)";

        try {
            PreparedStatement p = conn.prepareStatement(removeFromPendingQuery);
            p.setString(1, selectedStudent.getCnp());
            p.setString(2, course.getName());
            p.executeUpdate();

            p = conn.prepareStatement(addToEnrolledCourseQuery);
            p.setString(1, selectedStudent.getCnp());
            p.setString(2, course.getName());
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeFromCourse(Student selectedStudent, Course course) {
        String query = "DELETE FROM stud_enrolled_courses WHERE studentCNP=? AND courseName=?";

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, selectedStudent.getCnp());
            p.setString(2, course.getName());
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void pendingStudent(Student student, Course course) {
	        String query = "INSERT INTO stud_pending_courses (studentCNP, courseName) VALUES (?,?)";

	        try {
	            PreparedStatement p = conn.prepareStatement(query);
	            p.setString(1, student.getCnp());
	            p.setString(2, course.getName());
	            p.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
