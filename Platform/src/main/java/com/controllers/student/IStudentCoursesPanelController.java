package com.controllers.student;

import com.views.student.StudentCoursesPanel;
import com.views.student.StudentPanel;

public interface IStudentCoursesPanelController {

	void viewCourses();

	void stateChanged();

	void setStudentPanel(StudentPanel studentPanel);

	void setStudentCoursesPanel(StudentCoursesPanel studentCoursesPanel);

}
