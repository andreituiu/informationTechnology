package com.controllers.student.implementation;

import java.awt.Component;

import org.hibernate.sql.Update;

import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Student;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public class StudentProfileInformationPanelController implements IStudentProfileInformationPanelController {

	private StudentPanel studentPanel;
	private StudentProfileInformationPanel studentProfilePanel;
	private Student student;

	
	
	public StudentProfileInformationPanelController(Student student) {
		super();
		this.student = student;
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
		studentProfilePanel.setUsername(student.getName());
		studentProfilePanel.setSurname(student.getSurname());
		studentProfilePanel.setCNP(student.getCnp());
	}

}
