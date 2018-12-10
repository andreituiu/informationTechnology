package com.views.teacher;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.controllers.teacher.ITeacherCoursePanelController;
import com.model.Course;

public class TeacherCoursesPanel extends JPanel {

    private JTabbedPane tabbedPane;
    private JTextField searchTextField;
    private JButton btnSearch;
    private DefaultListModel<Course> coursesListModel;
    private JList<Course> coursesList;
    protected ITeacherCoursePanelController teacherCoursesPanelController;
    private TeacherManageStudentsPanel teacherManageStudentsPanel;
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

	private void initialize() {

        setLayout(null);
        
//        teacherManageStudentsPanel = new TeacherManageStudentsPanel(null, null, null);
//        teacherManageStudentsPanel = new TeacherManageStudentsPanel(null, null, null);

        searchTextField = new JTextField();
        searchTextField.setColumns(10);
        searchTextField.setBounds(10, 11, 317, 20);
        add(searchTextField);

        btnSearch = new JButton("Find");
        btnSearch.setBounds(353, 10, 80, 23);
        add(btnSearch);


        JScrollPane courses = new JScrollPane();
        courses.setLocation(10, 43);
        courses.setSize(137, 275);

        coursesListModel = new DefaultListModel<Course>();
        coursesList = new JList<Course>(coursesListModel);

        coursesList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    teacherCoursesPanelController.courseSelected((Course) coursesList
                            .getSelectedValue());
                }
            }
        });

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
        boxPanel.add(coursesList);
        courses.setViewportView(boxPanel);

        add(courses);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(157, 42, 560, 276);
        add(tabbedPane);

        tabbedPane.addTab("Students", null, teacherManageStudentsPanel, null);
        tabbedPane.addTab("Assignments", null, teacherManageAssignmentsPanel, null);

    }

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
        coursesList.setSelectedIndex(0);
        teacherCoursesPanelController.courseSelected(coursesList.getSelectedValue());
        
    }

    private void ereaseAll() {
        coursesListModel.clear();
    }
}
