package com.views.student;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.controllers.student.IStudentCoursesPanelController;
import com.views.common.ILanguagePanel;

@org.springframework.stereotype.Component
public class StudentCoursesPanel extends JPanel implements ILanguagePanel {

	@Autowired
	private StudentFindCoursePannel findCoursesPanel;

	@Autowired
	private StudentEnrolledCoursesPanel enrolledCoursesPanel;

	private JTabbedPane tabbedPane;

	@Autowired
	private IStudentCoursesPanelController studentCoursesPanelController;

	public StudentCoursesPanel(IStudentCoursesPanelController studentCoursesPanelController,
			StudentFindCoursePannel findCoursesPanel, StudentEnrolledCoursesPanel enrolledCoursesPanel) {
		super();
		this.studentCoursesPanelController = studentCoursesPanelController;
		this.findCoursesPanel = findCoursesPanel;
		this.enrolledCoursesPanel = enrolledCoursesPanel;

		initialzie();
	}

	public StudentCoursesPanel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void initialzie() {
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBounds(10, 11, 2000, 2000);
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

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {
		tabbedPane.setTitleAt(0, "findCourses");
		tabbedPane.setTitleAt(1, "enrolledCourses");

	}

}
