package com.controllers.student.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.controllers.student.IStudentFindCoursePannelController;
import com.controllers.student.IStudentFrameController;
import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Student;
import com.views.student.StudentFrame;

@Component
public class StudentFrameController implements IStudentFrameController {

	@Autowired
	private IStudentProfileInformationPanelController studentProfilePanelController;
	
	@Autowired
	private IStudentFindCoursePannelController studentFindCoursePannelController;
	
	@Autowired
	private IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;
	
	@Autowired
	private StudentFrame studentFrame;

	@Autowired
	@Qualifier("studentEmailPanelController")
	private IEmailPanelController studentEmailPanelController;

	public StudentFrameController() {
		super();
	}

	@Override
	public void setStudentFrame(StudentFrame studentFrame) {
		this.studentFrame = studentFrame;
	}

	@Override
	public void openFrame() {
		studentFrame.setVisible(true);
	}

	@Override
	public void setStudent(Student student) {
		studentProfilePanelController.setStudent(student);
		studentFindCoursePannelController.setStudent(student);
		studentEnrolledCoursesPanelController.setStudent(student);
		studentEmailPanelController.setUser(student);
		studentProfilePanelController.viewProfile();
	}

}
