package com.controllers.teacher.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

@Component
public class TeacherProfileController implements ITeacherProfileInformationPanelController {

	@Autowired
	private TeacherProfileInformationPanel teacherProfilePanel;
	private Teacher teacher;
	@Autowired
	private TeacherPanel teacherPanel;
	@FXML
	private TextField cnpTF;

	
	
	public TeacherProfileController(Teacher teacher) {
		super();
		this.teacher = teacher;
	}


	public TeacherProfileController() {
		super();
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



	public void update() {
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
	}


//	public void setTeacherPanel(Parent teacherPanel) {
//		this.teacherPanel = teacherPanel;
//	}


//	public Parent getTeacherPanel() {
//		return teacherPanel;
//	}

//	@FXML
//	public void modifyTeacher() {
//	}
//
//	@FXML
//	public void updateTeacher() {
//	}

}