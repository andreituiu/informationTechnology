package com.model.dao;

import java.util.List;

import com.model.Teacher;


public interface TeacherDAO {

	Teacher getTeacher(String cnp);
	List<Teacher> getAllTeachers();

}
