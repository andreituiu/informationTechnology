package com.controllers.teacher.implementation;

import com.controllers.teacher.ITeacherHeaderController;
import com.views.common.MailPanel;
import com.views.teacher.TeacherCourses;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

public class TeacherHeaderController implements ITeacherHeaderController {

	private TeacherProfileInformationPanel teacherProfilePanel;
	private TeacherPanel teacherPanel;
	private TeacherCourses teacherCourses;
	private MailPanel emailPanel;
	
	public TeacherHeaderController(TeacherProfileInformationPanel teacherProfilePanel,
			TeacherCourses teacherCourses, MailPanel emailPanel) {
		super();
		this.teacherProfilePanel = teacherProfilePanel;
		this.teacherCourses = teacherCourses;
		this.emailPanel = emailPanel;
	}

	
	@Override
	public void setTeacherPanel(TeacherPanel teacherPanel) {
		this.teacherPanel = teacherPanel;
	}



	@Override
	public void viewProfile() {
		teacherPanel.setPanel(teacherProfilePanel);
	}

	@Override
	public void viewCourses() {
		teacherPanel.setPanel(teacherCourses);
	}

	@Override
	public void viewEmail() {
		teacherPanel.setPanel(emailPanel);
	}

}
