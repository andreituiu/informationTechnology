package com.controllers.teacher;

import com.views.teacher.TeacherPanel;

public interface ITeacherHeaderController {

	void viewProfile();

	void viewCourses();
	
	void viewEmail();

	void setTeacherPanel(TeacherPanel teacherPanel);
}
