package com.views.student;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StudentCoursesPanel extends JPanel {
	private StudentFindCoursePannel findCoursesPanel;
	private StudentEnrolledCoursesPanel enrolledCoursesPanel;

	public StudentCoursesPanel() {
		setLayout(null);
		
		findCoursesPanel = new StudentFindCoursePannel();
		enrolledCoursesPanel = new StudentEnrolledCoursesPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 463, 334);
		add(tabbedPane);
		
		tabbedPane.addTab("Find courses", null, findCoursesPanel, null);
		tabbedPane.addTab("Enrolled courses", null, enrolledCoursesPanel, null);
	}
}
