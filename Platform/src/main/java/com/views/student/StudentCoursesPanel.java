package com.views.student;

import java.awt.Component;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.controllers.student.IStudentCoursesPanelController;

public class StudentCoursesPanel extends JPanel {
	
	private StudentFindCoursePannel findCoursesPanel;
	private StudentEnrolledCoursesPanel enrolledCoursesPanel;

	private JTabbedPane tabbedPane;

	private IStudentCoursesPanelController studentCoursesPanelController;

	public StudentCoursesPanel(IStudentCoursesPanelController studentCoursesPanelController,
			StudentFindCoursePannel findCoursesPanel, StudentEnrolledCoursesPanel enrolledCoursesPanel) {
		super();
		this.studentCoursesPanelController = studentCoursesPanelController;
		this.findCoursesPanel = findCoursesPanel;
		this.enrolledCoursesPanel = enrolledCoursesPanel;

		initialzie();
	}

	private void initialzie() {
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(10, 11, 463, 334);
		add(tabbedPane);

		tabbedPane.addTab("Find courses", null, findCoursesPanel, null);
		tabbedPane.addTab("Enrolled courses", null, enrolledCoursesPanel, null);

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				studentCoursesPanelController.stateChanged();
			}
		});
	}

	public void setLanguageBundle(ResourceBundle languageBundle)  {
		tabbedPane.setTitleAt(0, "findCourses");
		tabbedPane.setTitleAt(1, "enrolledCourses");
		
	}

}
