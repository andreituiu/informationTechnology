package com.controllers.student.implementation;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Student;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

@Component
public class StudentProfileInformationPanelController implements IStudentProfileInformationPanelController {

	@Autowired
	private StudentPanel studentPanel;
	
	@Autowired
	private StudentProfileInformationPanel studentProfilePanel;
	private Student student;

	
	
	public StudentProfileInformationPanelController(Student student) {
		super();
		this.student = student;
	}

	

	public StudentProfileInformationPanelController() {
		super();
		// TODO Auto-generated constructor stub
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


	@Override
	public void setStudent(Student student) {
		this.student = student;
	}

}
