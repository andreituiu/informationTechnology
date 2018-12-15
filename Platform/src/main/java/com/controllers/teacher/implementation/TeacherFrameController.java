package com.controllers.teacher.implementation;

import com.controllers.common.IEmailPanelController;
import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherFrameController;
import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.model.User;
import com.views.teacher.TeacherFrame;

public class TeacherFrameController implements ITeacherFrameController {

	private ITeacherProfileInformationPanelController teacherProfilePanelController;
	private ITeacherCoursePanelController teacherCoursesPanelController;
	private TeacherFrame teacherFrame;
	private IEmailPanelController mailPanelController;

	public TeacherFrameController(ITeacherProfileInformationPanelController teacherProfilePanelController,
			ITeacherCoursePanelController teacherCoursesPanelController, IEmailPanelController mailPanelController) {
				this.teacherProfilePanelController = teacherProfilePanelController;
				this.teacherCoursesPanelController = teacherCoursesPanelController;
				this.mailPanelController = mailPanelController;
	}
	
	
	@Override
	public void setTeacherFrame(TeacherFrame teacherFrame) {
		this.teacherFrame = teacherFrame;
	}



	@Override
	public void setTeacher(Teacher teacher) {
		teacherProfilePanelController.setTeacher(teacher);
		teacherCoursesPanelController.setTeacher(teacher);
	}

	@Override
	public void openFrame() {
		teacherFrame.setVisible(true);
	}


	@Override
	public void setUser(User user) {
		mailPanelController.setUser(user);
	}

}
