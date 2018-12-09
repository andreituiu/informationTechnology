package com.model.dao;

import java.util.List;

import com.model.Course;
import com.model.Student;

public interface CourseDAO {

	List<Course> getAllCourses();

	List<Course> getEnrolledCourses(Student student);

	List<Course> getAllCoursesContaining(String searchedText);
}
