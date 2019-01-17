package com.views.teacher;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherFrame extends JFrame {

	@Autowired
	private TeacherPanel teacherPanel;

	public TeacherFrame(TeacherPanel teacherPanel) throws HeadlessException {
		super();
		this.teacherPanel = teacherPanel;

		initialize();
	}

	public TeacherFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void initialize() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(215, 228, 242));
		teacherPanel.setLocation(0, 0);
		teacherPanel.setSize(1000, 700);
		getContentPane().add(teacherPanel);
		setSize(1000, 700);
		setResizable(false);
	}

}
