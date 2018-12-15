package com.views.student;

import java.awt.Color;
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
		getContentPane().setBackground(new Color(215, 228, 242));

		studentPanel.setLocation(0, 0);
		studentPanel.setSize(1000, 7000);
		getContentPane().add(studentPanel);
		setSize(1000, 700);
		setResizable(false);
	}

}
