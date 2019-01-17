package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Course;
import com.model.Student;
import com.model.Teacher;
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

	@Override
	public List<Course> getCoursesForTeacher(Teacher teacher) {
		String query = "SELECT * FROM course join teacher on teacherCNP=cnp WHERE teacherCNP=?";
		ResultSet resultSet = null;
		
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, teacher.getCnp());
			resultSet = p.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseMapper.getList(resultSet);
	}

	@Override
	public List<Course> getPendingCourses(Student student) {
		 String query = "SELECT * FROM (SELECT * FROM course JOIN teacher ON course.teacherCNP=teacher.cnp) as course_teaher JOIN stud_pending_courses ON course_teaher.course_name=stud_pending_courses.courseName WHERE stud_pending_courses.studentCNP = ?";
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
	public List<Course> getNotEnrolledCourses(Student student) {
		String query = "SELECT * FROM (SELECT * FROM course WHERE course_name NOT IN (SELECT courseName FROM stud_enrolled_courses WHERE stud_enrolled_courses.studentCNP=? UNION SELECT courseName FROM stud_pending_courses WHERE stud_pending_courses.studentCNP=?)) as notEnrolledCourse JOIN teacher ON notEnrolledCourse.teacherCNP=teacher.cnp";
		ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, student.getCnp());
            p.setString(2, student.getCnp());
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);
	}

	@Override
	public List<Course> getPendingCoursesContaining(Student student, String searchedText) {
		String query = "SELECT * FROM (SELECT * FROM course JOIN teacher ON course.teacherCNP=teacher.cnp) as course_teaher JOIN stud_pending_courses ON course_teaher.course_name=stud_pending_courses.courseName WHERE stud_pending_courses.studentCNP = ? AND (course_name LIKE ? OR specialization LIKE ? OR name LIKE ?)";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, student.getCnp());
            p.setString(2, "%" + searchedText +"%");
            p.setString(3, "%" + searchedText +"%");
            p.setString(4, "%" + searchedText +"%");
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);
	}

	@Override
	public List<Course> getEnrolledCoursesContaining(Student student, String searchedText) {
		String query = "SELECT * FROM (SELECT * FROM course JOIN teacher ON course.teacherCNP=teacher.cnp) as course_teaher JOIN stud_enrolled_courses ON course_teaher.course_name=stud_enrolled_courses.courseName WHERE stud_enrolled_courses.studentCNP = ? AND (course_name LIKE ? OR specialization LIKE ? OR name LIKE ?)";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, student.getCnp());
            p.setString(2, "%" + searchedText +"%");
            p.setString(3, "%" + searchedText +"%");
            p.setString(4, "%" + searchedText +"%");
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);
	}

	@Override
	public List<Course> getNotEnrolledCoursesContaining(Student student, String searchedText) {
		String query = "SELECT * FROM (SELECT * FROM course WHERE course_name NOT IN (SELECT courseName FROM stud_enrolled_courses WHERE stud_enrolled_courses.studentCNP=? UNION SELECT courseName FROM stud_pending_courses WHERE stud_pending_courses.studentCNP=?)) as notEnrolledCourse JOIN teacher ON notEnrolledCourse.teacherCNP=teacher.cnp WHERE course_name LIKE ? OR specialization LIKE ? OR name LIKE ?";
		ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, student.getCnp());
            p.setString(2, student.getCnp());
            p.setString(3, "%" + searchedText +"%");
            p.setString(4, "%" + searchedText +"%");
            p.setString(5, "%" + searchedText +"%");
            resultSet = p.executeQuery();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseMapper.getList(resultSet);
	}
	@Override
	public void saveNewCourse(Course course) {

		String query = "INSERT INTO course(course_name, teacherCNP, specialization) VALUES(?, ?, ?)";

		
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, course.getName());
			p.setString(2, course.getTeacher().getCnp());
			p.setString(3, course.getSpecialization().getName());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCourse(Course selectedCourse) {
		String query = "UPDATE course SET (course_name,specialization,teacherCNP) VaLUES(?,?,?)";
		try {
			PreparedStatement p = conn.prepareStatement(query);
			p.setString(1, selectedCourse.getName());
			p.setString(2, selectedCourse.getTeacher().getCnp());
			p.setString(3, selectedCourse.getSpecialization().getName());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
