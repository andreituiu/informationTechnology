package com.controllers.student.implementation;

import com.controllers.student.IStudentHeaderController;
import com.controllers.student.IStudentProfileInformationPanelController;
import com.views.common.Mail;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public class StudentHeaderController implements IStudentHeaderController {

	private StudentProfileInformationPanel studentProfilePanel;
	private StudentPanel studentPanel;
	private StudentCoursesPanel studentCoursesPanel;
	private Mail emailPanel;
	
	private IStudentProfileInformationPanelController studentProfilePanelController;
	
	public StudentHeaderController(IStudentProfileInformationPanelController studentProfilePanelController,
			StudentCoursesPanel studentCoursesPanel, Mail emailPanel) {
		super();
		this.studentProfilePanelController = studentProfilePanelController;
		this.studentCoursesPanel = studentCoursesPanel;
		this.emailPanel = emailPanel;
	}

	
	@Override
	public void setStudentPanel(StudentPanel studentPanel) {
		this.studentPanel = studentPanel;
	}



	@Override
	public void viewProfile() {
		studentProfilePanelController.viewProfile();
	}

	@Override
	public void viewCourses() {
		studentPanel.setPanel(studentCoursesPanel);
	}

	@Override
	public void viewEmail() {
		studentPanel.setPanel(emailPanel);
	}

}
