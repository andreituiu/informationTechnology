package com.views.teacher;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.util.ResourceBundle;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.views.student.StudentFindCoursePannel;

import javax.swing.JTextArea;

public class TeacherCoursesPanel extends JPanel{
	
	private TeacherFindCoursePannel findCoursesPanel;
	private JTabbedPane tabbedPane;
	private JTextArea txtrStudentsWaitingFor;
	private JTextArea txtrEnroledStudents;
	private TeacherEnrolledStudentsPanel enrolledStudentsPanel;
	private TeacherWaitingStudentsPanel waitingStudentsPanel;
	
	public TeacherCoursesPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(null);
		
		findCoursesPanel = new TeacherFindCoursePannel();
		enrolledStudentsPanel = new TeacherEnrolledStudentsPanel();
		waitingStudentsPanel = new TeacherWaitingStudentsPanel();
		
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 108, 300, 263);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Students", null, panel, null);
		panel.setLayout(null);
		
		
		panel.add(waitingStudentsPanel);
		panel.add(enrolledStudentsPanel);
		

	}
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		tabbedPane.setTitleAt(0, "students");		
	}
}
