package com.model.dao.hibernateimplementation;

import java.util.List;

import com.model.Course;
import com.model.Student;
import com.model.Teacher;
import com.model.dao.CourseDAO;

public class CourseDAOHImpl extends BaseDAOHImpl<Course, Integer> implements CourseDAO {

	public CourseDAOHImpl() {
		super(Course.class);
	}


}
