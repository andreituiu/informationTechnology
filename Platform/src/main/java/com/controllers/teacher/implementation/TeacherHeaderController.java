package com.controllers.teacher.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherHeaderController;
import com.controllers.teacher.ITeacherProfileInformationPanelController;

@Component
public class TeacherHeaderController implements ITeacherHeaderController {

    @Autowired
	private ITeacherProfileInformationPanelController teacherProfilePanelController;
    
    @Autowired
    private IEmailPanelController emailPanelController;

    @Autowired
    private ITeacherCoursePanelController teacherCoursesPanelController;

    public TeacherHeaderController(
            ITeacherProfileInformationPanelController teacherProfilePanelController,
            ITeacherCoursePanelController teacherCoursesPanelController,
            IEmailPanelController emailPanelController) {
        super();
        this.teacherProfilePanelController = teacherProfilePanelController;
        this.teacherCoursesPanelController = teacherCoursesPanelController;
        this.emailPanelController = emailPanelController;
    }
    
    

    public TeacherHeaderController() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
    public void viewProfile() {
        teacherProfilePanelController.viewProfile();
    }

    @Override
    public void viewCourses() {
        teacherCoursesPanelController.viewCourse();
    }

    @Override
    public void viewEmail() {
        emailPanelController.viewEmail();
    }
}
