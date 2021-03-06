package com.controllers.student;

import com.model.Student;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public interface IStudentProfileInformationPanelController {

	void viewProfile();

	void setStudentPanel(StudentPanel studentPanel);

	void setStudentProfileInformationPanel(StudentProfileInformationPanel studentProfilePanel);

	void setStudent(Student student);

	void changePassword();

	void changeSave();

}
