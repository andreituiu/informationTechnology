package com.controllers.student.implementation;

import java.awt.Component;

import org.hibernate.sql.Update;

import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Student;
import com.model.dao.StudentDAO;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public class StudentProfileInformationPanelController implements IStudentProfileInformationPanelController {

	private StudentPanel studentPanel;
	private StudentProfileInformationPanel studentProfilePanel;
	private Student student;
	private StudentDAO studentDAO;

	
	
	public StudentProfileInformationPanelController(Student student) {
		super();
		this.student = student;
	}

	public StudentProfileInformationPanelController() {
		super();
	}


	@Override
	public void setStudentPanel(StudentPanel studentPanel) {
		this.studentPanel = studentPanel;
	}


	@Override
	public void setStudentProfileInformationPanel(StudentProfileInformationPanel studentProfilePanel) {
		this.studentProfilePanel = studentProfilePanel;
	}



	@Override
	public void viewProfile() {
		update();
		studentPanel.setPanel(studentProfilePanel);
	}



	private void update() {
		studentProfilePanel.eraseAll();
		studentProfilePanel.setUsername(student.getName());
		studentProfilePanel.setSurname(student.getSurname());
		studentProfilePanel.setCNP(student.getCnp());
		studentProfilePanel.setExternalEmail(student.getExternalEmail());
		studentProfilePanel.setInternalEmail(student.getInternalEmail());
		studentProfilePanel.setSpecialization(student.getSpecialization());
		studentProfilePanel.setYearStudy(student.getStudyYear());
	}


	@Override
	public void setStudent(Student student) {
		this.student = student;
		update();
	}


	@Override
	public void changePassword() {
		String oldPass = studentProfilePanel.getOldPassword();
		String newPass = studentProfilePanel.getNewPassword();
		String confirmPass = studentProfilePanel.getConfirmPassword();
		
		if(student.getPassword().equals(oldPass)) {
			if(newPass.equals(confirmPass)) {
				student.setPassword(newPass);
				studentDAO.update(student);
			}
		}
	}


	@Override
	public void changeSave() {
		student.setExternalEmail(studentProfilePanel.getExternalEmail());
		studentDAO.update(student);
	}

}
