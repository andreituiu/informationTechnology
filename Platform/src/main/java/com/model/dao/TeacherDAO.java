package com.model.dao;

import java.util.List;

import com.model.Course;
import com.model.Teacher;
import com.model.User;


public interface TeacherDAO extends BaseDAO<Teacher, String>{

	List<Teacher> findAll();

//	Teacher getTeacher(String cnp);
//	List<Teacher> getAllTeachers();
//	Teacher getTeacherFor(Course course);
//	void save(Teacher teacher);
//	void deleteUser(User selectedUser);

}
