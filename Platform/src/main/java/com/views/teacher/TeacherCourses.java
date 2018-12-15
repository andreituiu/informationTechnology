package com.views.teacher;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class TeacherCourses extends JPanel{
	private JTextField textField;
	
	public TeacherCourses() {
		initialize();
	}

	private void initialize() {
		setLayout(null);
		
		
		JButton button = new JButton("Find");
		button.setBounds(360, 64, 80, 23);
		add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 65, 317, 20);
		add(textField);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 108, 120, 263);
		add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(140, 108, 300, 263);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Students", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane studentsWaiting_scrollPane = new JScrollPane();
		studentsWaiting_scrollPane.setBounds(10, 11, 275, 88);
		panel.add(studentsWaiting_scrollPane);
		
		JTextArea txtrStudentsWaitingFor = new JTextArea();
		txtrStudentsWaitingFor.setText("Students waiting for confimation");
		studentsWaiting_scrollPane.setColumnHeaderView(txtrStudentsWaitingFor);
		
		JScrollPane studentsEnrl_scrollPane = new JScrollPane();
		studentsEnrl_scrollPane.setBounds(10, 124, 275, 88);
		panel.add(studentsEnrl_scrollPane);
		
		JTextArea txtrEnroledStudents = new JTextArea();
		txtrEnroledStudents.setText("Enroled students");
		studentsEnrl_scrollPane.setColumnHeaderView(txtrEnroledStudents);
	}
}
