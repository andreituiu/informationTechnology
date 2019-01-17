package com.controllers.teacher.implementation;

import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

public class TeacherProfileInformationPanelController implements ITeacherProfileInformationPanelController {

	private TeacherPanel teacherPanel;
	private TeacherProfileInformationPanel teacherProfilePanel;
	private Teacher teacher;

	
	
	public TeacherProfileInformationPanelController(Teacher teacher) {
		super();
		this.teacher = teacher;
	}


	@Override
	public void setTeacherPanel(TeacherPanel teacherPanel) {
		this.teacherPanel = teacherPanel;
	}


	@Override
	public void setTeacherProfileInformationPanel(TeacherProfileInformationPanel teacherProfilePanel) {
		this.teacherProfilePanel = teacherProfilePanel;
	}



	@Override
	public void viewProfile() {
		update();
		teacherPanel.setPanel(teacherProfilePanel);
	}



	private void update() {
		teacherProfilePanel.setUsername(teacher.getName());
		teacherProfilePanel.setSurname(teacher.getSurname());
		teacherProfilePanel.setCNP(teacher.getCnp());
	}


	@Override
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
