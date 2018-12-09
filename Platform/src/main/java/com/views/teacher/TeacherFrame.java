package com.views.teacher;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class TeacherFrame extends JFrame {
	private TeacherPanel teacherPanel;

	public TeacherFrame(TeacherPanel teacherPanel) throws HeadlessException {
		super();
		this.teacherPanel = teacherPanel;
	
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);

		teacherPanel.setLocation(0, 0);
		teacherPanel.setSize(476, 400);
		getContentPane().add(teacherPanel);
	}

}
