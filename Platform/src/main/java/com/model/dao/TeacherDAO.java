package com.model.dao;

import java.util.List;

import com.model.Course;
import com.model.Teacher;
import com.model.User;

public interface TeacherDAO {

	Teacher getTeacher(String cnp);

	List<Teacher> getAllTeachers();

	Teacher getTeacherFor(Course course);

	void save(Teacher teacher);

	void deleteUser(User selectedUser);

	void update(Teacher teacher);

}
