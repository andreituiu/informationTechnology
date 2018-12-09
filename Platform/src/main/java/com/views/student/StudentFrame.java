package com.views.student;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class StudentFrame extends JFrame {
	private StudentPanel studentPanel;

	public StudentFrame(StudentPanel studentPanel) throws HeadlessException {
		super();
		this.studentPanel = studentPanel;
	
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);

		studentPanel.setLocation(0, 0);
		studentPanel.setSize(476, 400);
		getContentPane().add(studentPanel);
	}

}
