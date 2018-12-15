package com.controllers.student.implementation;

import com.controllers.common.IEmailPanelController;
import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.controllers.student.IStudentFindCoursePannelController;
import com.controllers.student.IStudentFrameController;
import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Student;
import com.model.User;
import com.views.student.StudentFrame;

public class StudentFrameController implements IStudentFrameController {

	private IStudentProfileInformationPanelController studentProfilePanelController;
	private IStudentFindCoursePannelController studentFindCoursePannelController;
	private IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;
	private StudentFrame studentFrame;
	private IEmailPanelController mailPanelController;

	public StudentFrameController(IStudentProfileInformationPanelController studentProfilePanelController,
			IStudentFindCoursePannelController studentFindCoursePannelController,
			IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController, IEmailPanelController mailPanelController) {
				this.studentProfilePanelController = studentProfilePanelController;
				this.studentFindCoursePannelController = studentFindCoursePannelController;
				this.studentEnrolledCoursesPanelController = studentEnrolledCoursesPanelController;
				this.mailPanelController = mailPanelController;
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
	}


	@Override
	public void setUser(User user) {
		mailPanelController.setUser(user);
	}

}
