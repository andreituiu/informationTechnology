package com.controllers.teacher;

import com.model.Teacher;
import com.views.teacher.TeacherPanel;
import com.views.teacher.TeacherProfileInformationPanel;

public interface ITeacherProfileInformationPanelController {

	void viewProfile();

	void setTeacherPanel(TeacherPanel teacherPanel);

	void setTeacherProfileInformationPanel(TeacherProfileInformationPanel teacherProfilePanel);

	void setTeacher(Teacher teacher);

	void changePassword();

	void changeSave();

}
