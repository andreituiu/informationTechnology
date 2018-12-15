package com.model.dao;

import java.util.List;

import com.model.Course;
import com.model.Student;
import com.model.Teacher;

public interface CourseDAO {

	List<Course> getAllCourses();

	List<Course> getEnrolledCourses(Student student);

	List<Course> getAllCoursesContaining(String searchedText);

	List<Course> getCoursesForTeacher(Teacher teacher);

	List<Course> getPendingCourses(Student student);

	List<Course> getNotEnrolledCourses(Student student);

	List<Course> getPendingCoursesContaining(Student student, String searchedText);

	List<Course> getEnrolledCoursesContaining(Student student, String searchedText);

	List<Course> getNotEnrolledCoursesContaining(Student student, String searchedText);


	void saveNewCourse(Course course);

	void updateCourse(Course selectedCourse, String oldCourseName);
}
