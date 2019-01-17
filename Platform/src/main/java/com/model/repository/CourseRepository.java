package com.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	List<Course> findByNameContains(String searchedString);

	List<Course> findByNameContainingOrTeacherNameContainingOrTeacherSurnameContainingOrSpecializationNameContaining(
			String courseName, String teacherName, String teacherSurname, String specializationName);

}
