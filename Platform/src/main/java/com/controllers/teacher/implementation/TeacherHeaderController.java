package com.controllers.teacher.implementation;

import com.controllers.common.IEmailPanelController;
import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherHeaderController;
import com.controllers.teacher.ITeacherProfileInformationPanelController;

public class TeacherHeaderController implements ITeacherHeaderController {

    private ITeacherProfileInformationPanelController teacherProfilePanelController;
    private IEmailPanelController emailPanelController;
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
