package com.controllers.student.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.controllers.student.IStudentCoursesPanelController;
import com.controllers.student.IStudentHeaderController;
import com.controllers.student.IStudentProfileInformationPanelController;

@Component
public class StudentHeaderController implements IStudentHeaderController {

	@Autowired
	private IStudentProfileInformationPanelController studentProfilePanelController;

	@Autowired
	@Qualifier("studentEmailPanelController")
	private IEmailPanelController emailPanelController;

	@Autowired
	private IStudentCoursesPanelController studentCoursesPanelController;

	public StudentHeaderController() {
		super();
	}

	@Override
	public void viewProfile() {
		studentProfilePanelController.viewProfile();
	}

	@Override
	public void viewCourses() {
		studentCoursesPanelController.viewCourses();
	}

	@Override
	public void viewEmail() {
		emailPanelController.viewEmail();
	}

}
