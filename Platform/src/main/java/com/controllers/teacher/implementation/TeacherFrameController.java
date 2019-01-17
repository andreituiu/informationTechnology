package com.controllers.teacher.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.controllers.teacher.ITeacherFrameController;
import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.model.Teacher;
import com.views.teacher.TeacherFrame;

@Component
public class TeacherFrameController implements ITeacherFrameController {

	@Autowired
	private ITeacherProfileInformationPanelController teacherProfileController;

	@Autowired
	private TeacherFrame teacherFrame;

	@Autowired
	private TeacherCourseController teacherCoursesController;

	@Autowired
	@Qualifier("teacherEmailPanelController")
	private IEmailPanelController teacherEmailPanelController;
	
	public TeacherFrameController() {
		super();
	}

	@Override
	public void setTeacherFrame(TeacherFrame teacherFrame) {
		this.teacherFrame = teacherFrame;
	}

	@Override
	public void setTeacher(Teacher teacher) {
		teacherProfileController.setTeacher(teacher);
		teacherCoursesController.setTeacher(teacher);
		teacherEmailPanelController.setUser(teacher);
		teacherProfileController.viewProfile();
	}

	@Override
	public void openFrame() {
		teacherFrame.setVisible(true);
	}

}
