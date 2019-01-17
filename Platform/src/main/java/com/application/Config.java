package com.application;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.controllers.common.IEmailPanelController;
import com.controllers.common.implementation.EmailPanelController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.views.common.ISupportPanel;
import com.views.common.MailPanel;
import com.views.teacher.TeacherStudentsTablePanel;

@Configuration
@ComponentScan(basePackages = {"com.model.dao.hibernateimplementation",
"com.model.dao"})
@Import({DAOInitializerBean.class, ControllerBeanInitializer.class, TeacherControllerBeanInitializer.class})
public class Config {
	@Bean(value="roLanguageBundle")
    public ResourceBundle roLanguageBundle() {
		Locale romainianLocale = new Locale("ro", "RO");
		ResourceBundle roBundle = ResourceBundle.getBundle("LanguageBundle", romainianLocale);
		return roBundle;
    }
	
	@Bean(value="enLanguageBundle")
    public ResourceBundle enLanguageBundle() {
        Locale englishLocale = new Locale("en", "EN");
		ResourceBundle enBundle = ResourceBundle.getBundle("LanguageBundle", englishLocale);
		return enBundle;
    }
	
	@Bean(value="adminEmailPanelController")
	public IEmailPanelController adminEmailPanelController(@Qualifier("adminPanel") ISupportPanel adminPanel, MailPanel mailPanel) {
		IEmailPanelController emailPanelController = new EmailPanelController();
		emailPanelController.setSupportPanel(adminPanel);
		emailPanelController.setMailPanel(mailPanel);
		mailPanel.setMailPanelController(emailPanelController);
		return emailPanelController;
	}
	
	@Bean(value="waitingStudentsTablePanel")
	public TeacherStudentsTablePanel waitingStudentsTablePanel(ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController) {
		TeacherStudentsTablePanel teacherStudentsTablePanel = new TeacherStudentsTablePanel();
		teacherStudentsTablePanel.setTeacherManageAssignmentsPanelController(teacherManageAssignmentsPanelController);
		return teacherStudentsTablePanel;
	}
	
	@Bean(value="enrolledStudentsTablePanel")
	public TeacherStudentsTablePanel enrolledStudentsTablePanel(ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController) {
		TeacherStudentsTablePanel teacherStudentsTablePanel = new TeacherStudentsTablePanel();
		teacherStudentsTablePanel.setTeacherManageAssignmentsPanelController(teacherManageAssignmentsPanelController);
		return teacherStudentsTablePanel;
	}
	
	@Bean(value="studentsTablePanel")
	public TeacherStudentsTablePanel studentsTablePanel(ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController) {
		TeacherStudentsTablePanel teacherStudentsTablePanel = new TeacherStudentsTablePanel();
		teacherStudentsTablePanel.setTeacherManageAssignmentsPanelController(teacherManageAssignmentsPanelController);
		return teacherStudentsTablePanel;
	}
	
}