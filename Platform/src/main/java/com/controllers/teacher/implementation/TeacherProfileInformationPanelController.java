package com.controllers.teacher.implementation;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.model.repository.TeacherRepository;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

@Component
public class TeacherProfileInformationPanelController implements ITeacherProfileInformationPanelController {

	@Autowired
	private TeacherPanel teacherPanel;
	
	@Autowired
	private TeacherProfileInformationPanel teacherProfilePanel;
	private Teacher teacher;
	
	@Autowired
	private TeacherRepository teacherRepository;

	
	

	public TeacherProfileInformationPanelController() {
		super();
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
		
		ResourceBundle languageBundle = teacherProfilePanel.getLanguageBundle();
		
		if(teacher.getPassword().equals(oldPass)) {
			if(newPass.equals(confirmPass)) {
				teacher.setPassword(newPass);
				teacherRepository.save(teacher);
				String passwordSavedMessage = "Password saved";
				if(languageBundle != null) {
					passwordSavedMessage = languageBundle.getString("password.saved");
				}
				teacherProfilePanel.showPopup(passwordSavedMessage );
				return;
			}
		}
		
		String wrongPasswordMessage = "Wrong password";
		if(languageBundle != null) {
			wrongPasswordMessage = languageBundle.getString("password.wrong");
		}
		teacherProfilePanel.showPopup(wrongPasswordMessage );
	}


	@Override
	public void changeSave() {
		teacher.setExternalEmail(teacherProfilePanel.getExternalEmail());
		teacherRepository.save(teacher);
	}

}
