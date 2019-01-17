package com.views.teacher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCoursePanelController;
import com.model.Course;
import com.views.common.ILanguagePanel;
import java.awt.Font;

@Component
public class TeacherCoursesPanel extends JPanel implements ILanguagePanel {

	private JTabbedPane tabbedPane;
	private JTextField searchTextField;
	private JButton btnSearch;
	private DefaultListModel<Course> coursesListModel;
	private JList<Course> coursesList;

	@Autowired
	private ITeacherCoursePanelController teacherCoursesPanelController;

	@Autowired
	private TeacherManageStudentsPanel teacherManageStudentsPanel;

	@Autowired
	private TeacherManageAssignmentsPanel teacherManageAssignmentsPanel;

	public TeacherCoursesPanel(ITeacherCoursePanelController teacherCoursesPanelController,
			TeacherManageStudentsPanel teacherManageStudentsPanel,
			TeacherManageAssignmentsPanel teacherManageAssignmentsPanel) {
		super();
		this.teacherCoursesPanelController = teacherCoursesPanelController;
		this.teacherManageStudentsPanel = teacherManageStudentsPanel;
		this.teacherManageAssignmentsPanel = teacherManageAssignmentsPanel;

		initialize();
	}

	public TeacherCoursesPanel() {
		super();
	}

	@PostConstruct
	private void initialize() {
		setBackground(new Color(215, 228, 242));
		setLayout(null);

		// teacherManageStudentsPanel = new TeacherManageStudentsPanel(null,
		// null, null);
		// teacherManageStudentsPanel = new TeacherManageStudentsPanel(null,
		// null, null);
		// teacherManageAssignmentsPanel= new
		// TeacherManageAssignmentsPanel(null,null);

		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		searchTextField.setBounds(10, 11, 659, 35);
		add(searchTextField);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(681, 10, 209, 35);
		add(btnSearch);

		coursesListModel = new DefaultListModel<Course>();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(174, 75, 728, 459);
		add(tabbedPane);

		tabbedPane.addTab("Students", null, teacherManageStudentsPanel, null);
		tabbedPane.addTab("Assignments", null, teacherManageAssignmentsPanel, null);
		
		JScrollPane scrollCourses = new JScrollPane();
	
		coursesList = new JList<Course>(coursesListModel);
		coursesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollCourses.setBounds(10, 91, 135, 443);
		scrollCourses.setViewportView(coursesList);
		add(scrollCourses);
		
//		coursesList = new JList<Course>(coursesListModel);

		coursesList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					teacherCoursesPanelController.courseSelected((Course) coursesList.getSelectedValue());
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teacherCoursesPanelController.searchCourses();
			}
		});

//		JPanel boxPanel = new JPanel();
//		boxPanel.setBounds(10, 91, 135, 443);
//		add(boxPanel);
//		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
//		boxPanel.add(coursesList);

		JScrollPane courses = new JScrollPane();
		courses.setBounds(10, 91, 135, 361);
		add(courses);

	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {
		tabbedPane.setTitleAt(0, "students");
	}

	public void populateCourses(List<Course> courses) {
		ereaseAll();
		if (courses == null || courses.isEmpty()) {
			return;
		}
		for (Course course : courses) {
			coursesListModel.addElement(course);
		}
		coursesList.setModel(coursesListModel);
		coursesList.setSelectedIndex(0);
		teacherCoursesPanelController.courseSelected(coursesList.getSelectedValue());

	}

	private void ereaseAll() {
		coursesListModel.clear();
	}

	public String getSearchdString() {
		return searchTextField.getText();
	}
}
