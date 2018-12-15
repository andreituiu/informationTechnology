package com.controllers.student.implementation;

import com.controllers.common.IEmailPanelController;
import com.controllers.student.IStudentCoursesPanelController;
import com.controllers.student.IStudentHeaderController;
import com.controllers.student.IStudentProfileInformationPanelController;
import com.views.common.MailPanel;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public class StudentHeaderController implements IStudentHeaderController {

	
	private IStudentProfileInformationPanelController studentProfilePanelController;
	private IEmailPanelController emailPanelController;
	private IStudentCoursesPanelController studentCoursesPanelController;
	

	


	public StudentHeaderController(IStudentProfileInformationPanelController studentProfilePanelController,
			IStudentCoursesPanelController studentCoursesPanelController, IEmailPanelController emailPanelController) {
		super();
		this.studentProfilePanelController = studentProfilePanelController;
		this.studentCoursesPanelController = studentCoursesPanelController;
		this.emailPanelController = emailPanelController;
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
