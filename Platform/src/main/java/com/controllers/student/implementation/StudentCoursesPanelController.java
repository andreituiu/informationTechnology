package com.controllers.student.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentCoursesPanelController;
import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.controllers.student.IStudentFindCoursePannelController;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentPanel;

@Component
public class StudentCoursesPanelController implements IStudentCoursesPanelController {

	@Autowired
	private StudentPanel studentPanel;

	@Autowired
	private StudentCoursesPanel studentCoursesPanel;

	@Autowired
	private IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;

	@Autowired
	private IStudentFindCoursePannelController studentFindCoursePannelController;

	public StudentCoursesPanelController() {
		super();
	}

	@Override
	public void setStudentPanel(StudentPanel studentPanel) {
		this.studentPanel = studentPanel;
	}

	@Override
	public void setStudentCoursesPanel(StudentCoursesPanel studentCoursesPanel) {
		this.studentCoursesPanel = studentCoursesPanel;
	}

	@Override
	public void viewCourses() {
		stateChanged();
		studentPanel.setPanel(studentCoursesPanel);
	}

	@Override
	public void stateChanged() {
		studentFindCoursePannelController.update();
		studentEnrolledCoursesPanelController.update();
	}

}
