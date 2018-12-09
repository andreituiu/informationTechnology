package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Course;
import com.model.Student;
import com.model.dao.CourseDAO;
import com.model.mapper.CourseMapper;

public class CourseDAOImpl implements CourseDAO {
	private Connection conn;
    private CourseMapper courseMapper;

	public CourseDAOImpl(CourseMapper courseMapper, Connection conn) {
		super();
		this.conn = conn;
		this.courseMapper = courseMapper;
	}

	@Override
	public List<Course> getAllCourses() {
        String query = "SELECT * FROM course JOIN teacher ON course.teacherCNP=teacher.cnp";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);

	}

	@Override
	public List<Course> getEnrolledCourses(Student student) {
        String query = "SELECT * FROM (SELECT * FROM course JOIN teacher ON course.teacherCNP=teacher.cnp) as course_teaher JOIN stud_enrolled_courses ON course_teaher.course_name=stud_enrolled_courses.courseName WHERE stud_enrolled_courses.studentCNP = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, student.getCnp());
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);
	}

	@Override
	public List<Course> getAllCoursesContaining(String searchedText) {
	    String query = "SELECT * FROM course JOIN teacher ON course.teacherCNP=teacher.cnp WHERE course.course_name LIKE ? OR course.specialization LIKE ? OR teacher.name LIKE ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, "%" + searchedText + "%");
            p.setString(2, "%" + searchedText + "%");
            p.setString(3, "%" + searchedText + "%");
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);

	}

}
