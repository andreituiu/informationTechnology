package com.views.teacher;

import java.awt.Color;
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
		getContentPane().setBackground(new Color(215, 228, 242));
//		teacherPanel = new TeacherPanel(null, null);
		teacherPanel.setLocation(0, 0);
		teacherPanel.setSize(1000, 700);
		getContentPane().add(teacherPanel);
		setSize(1000, 700);
		setResizable(false);
	}

}
