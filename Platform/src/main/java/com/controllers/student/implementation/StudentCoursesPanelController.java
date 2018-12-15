package com.controllers.student.implementation;

import com.controllers.student.IStudentCoursesPanelController;
import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.controllers.student.IStudentFindCoursePannelController;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentPanel;

public class StudentCoursesPanelController implements IStudentCoursesPanelController {

	private StudentPanel studentPanel;
	private StudentCoursesPanel studentCoursesPanel;
	private IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;
	private IStudentFindCoursePannelController studentFindCoursePannelController;

	
	
	public StudentCoursesPanelController(IStudentFindCoursePannelController studentFindCoursePannelController, 
			IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController) {
		super();
		this.studentFindCoursePannelController = studentFindCoursePannelController;
		this.studentEnrolledCoursesPanelController = studentEnrolledCoursesPanelController;
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
