package com.application;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.controllers.student.IStudentHeaderController;
import com.controllers.student.IStudentProfileInformationPanelController;
import com.controllers.student.implementation.StudentHeaderController;
import com.controllers.student.implementation.StudentProfileInformationPanelController;
import com.model.Student;
import com.model.dao.StudentDAO;
import com.model.dao.implementation.StudentDAOImpl;
import com.views.common.Mail;
import com.views.student.StudentCoursesPanel;
import com.views.student.StudentFrame;
import com.views.student.StudentHeader;
import com.views.student.StudentPanel;
import com.views.student.StudentProfileInformationPanel;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private StudentFrame studentFrame;

	public void run() {
//		init();
		initialize();
		studentFrame.setVisible(true);
	}

	private void init() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		StudentDAO studentDAO = new StudentDAOImpl(factory);
		Student s = studentDAO.getStudent("1");
		if(s != null) {
			System.out.println(s.getCnp());
		}else {
			System.out.println("student not found");
		}
	}

	private void initialize() {
		StudentProfileInformationPanel studentProfilePanel = new StudentProfileInformationPanel();
		StudentCoursesPanel studentCoursesPanel = new StudentCoursesPanel();
		Mail emailPanel = new Mail();
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		StudentDAO studentDAO = new StudentDAOImpl(factory);
		Student student = studentDAO.getStudent("1");
		if(student != null) {
			System.out.println(student.getCnp());
		}else {
			System.out.println("student not found");
		}
		
		IStudentProfileInformationPanelController studentProfilePanelController = new StudentProfileInformationPanelController(student);
		IStudentHeaderController studentHeaderController = new StudentHeaderController(studentProfilePanelController,
				studentCoursesPanel, emailPanel);
		StudentHeader studentHeader = new StudentHeader(studentHeaderController);
		StudentPanel studentPanel = new StudentPanel(studentHeader, studentProfilePanel);

		
		studentProfilePanelController.setStudentPanel(studentPanel);
		studentProfilePanelController.setStudentProfileInformationPanel(studentProfilePanel);
		studentHeaderController.setStudentPanel(studentPanel);
		
		studentFrame = new StudentFrame(studentPanel);
	}

}
