package com.controllers.teacher;

import org.springframework.stereotype.Component;

import com.model.Teacher;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

@Component
public interface ITeacherProfileInformationPanelController {

	void viewProfile();

	void setTeacherPanel(TeacherPanel teacherPanel);

	void setTeacherProfileInformationPanel(TeacherProfileInformationPanel teacherProfilePanel);

	void setTeacher(Teacher teacher);

	void changePassword();

	void changeSave();

}
