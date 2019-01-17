package com.views.student;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentFrame extends JFrame {

	@Autowired
	private StudentPanel studentPanel;

	public StudentFrame() throws HeadlessException {
		super();
	}

	@PostConstruct
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
