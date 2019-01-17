package com.controllers.student.implementation;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Student;
import com.model.repository.StudentRepository;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

@Component
public class StudentProfileInformationPanelController implements IStudentProfileInformationPanelController {

	@Autowired
	private StudentPanel studentPanel;

	@Autowired
	private StudentProfileInformationPanel studentProfilePanel;
	private Student student;

	@Autowired
	private StudentRepository studentRepository;

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
		studentProfilePanel.setUsername(student.getName());
		studentProfilePanel.setSurname(student.getSurname());
		studentProfilePanel.setCNP(student.getCnp());
		studentProfilePanel.setExternalEmail(student.getExternalEmail());
		studentProfilePanel.setInternalEmail(student.getInternalEmail());
		studentProfilePanel.setYearStudy(student.getStudyYear());
		studentProfilePanel.setSpecialization(student.getSpecialization());
	}

	@Override
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public void changePassword() {
		String oldPass = studentProfilePanel.getOldPassword();
		String newPass = studentProfilePanel.getNewPassword();
		String confirmPass = studentProfilePanel.getConfirmPassword();

		ResourceBundle languageBundle = studentProfilePanel.getLanguageBundle();

		if (student.getPassword().equals(oldPass)) {
			if (newPass.equals(confirmPass)) {
				student.setPassword(newPass);
				studentRepository.save(student);
				
				String passwordSavedMessage = "Password saved";
				if(languageBundle != null) {
					passwordSavedMessage = languageBundle.getString("password.saved");
				}
				studentProfilePanel.showPopup(passwordSavedMessage );
				return;
			}
		}
		
		String wrongPasswordMessage = "Wrong password";
		if(languageBundle != null) {
			wrongPasswordMessage = languageBundle.getString("password.wrong");
		}
		studentProfilePanel.showPopup(wrongPasswordMessage );
	}

	@Override
	public void changeSave() {
		student.setExternalEmail(studentProfilePanel.getExternalEmail());
		studentRepository.save(student);
	}

}
