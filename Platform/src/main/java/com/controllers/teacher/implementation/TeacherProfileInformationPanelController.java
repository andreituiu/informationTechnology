package com.controllers.teacher.implementation;

import javax.swing.JComponent;

import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.model.dao.TeacherDAO;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

public class TeacherProfileInformationPanelController implements ITeacherProfileInformationPanelController {

	private TeacherPanel teacherPanel;
	private TeacherProfileInformationPanel teacherProfilePanel;
	private Teacher teacher;
	private TeacherDAO teacherDAO;

	
	
	public TeacherProfileInformationPanelController(Teacher teacher, TeacherDAO teacherDAO) {
		super();
		this.teacher = teacher;
		this.teacherDAO = teacherDAO;
	}
	
	public TeacherProfileInformationPanelController(TeacherDAO teacherDAO) {
		super();
		this.teacherDAO = teacherDAO;
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
		teacherProfilePanel.eraseAll();
		teacherProfilePanel.setUsername(teacher.getName());
		teacherProfilePanel.setSurname(teacher.getSurname());
		teacherProfilePanel.setCNP(teacher.getCnp());
		teacherProfilePanel.setExternalEmail(teacher.getExternalEmail());
		teacherProfilePanel.setInternalEmail(teacher.getInternalEmail());
	}


	@Override
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
		update();
	}


	@Override
	public void changePassword() {
		String oldPass = teacherProfilePanel.getOldPassword();
		String newPass = teacherProfilePanel.getNewPassword();
		String confirmPass = teacherProfilePanel.getConfirmPassword();
		
		if(teacher.getPassword().equals(oldPass)) {
			if(newPass.equals(confirmPass)) {
				teacher.setPassword(newPass);
				teacherDAO.update(teacher);
			}
		}
	}


	@Override
	public void changeSave() {
		teacher.setExternalEmail(teacherProfilePanel.getExternalEmail());
		teacherDAO.update(teacher);
	}

}
