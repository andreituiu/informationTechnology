package com.views.teacher;

import javax.swing.JPanel;

import com.controllers.teacher.ITeacherHeaderController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TeacherHeader extends JPanel {
	protected ITeacherHeaderController teacherHeaderController;

	public TeacherHeader(ITeacherHeaderController teacherHeaderController) {
		this.teacherHeaderController = teacherHeaderController;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(36, 11, 89, 23);
		add(btnProfile);

		JButton btnCourses = new JButton("Courses");
		btnCourses.setBounds(181, 11, 89, 23);
		add(btnCourses);

		JButton btnMail = new JButton("Mail");
		btnMail.setBounds(329, 11, 89, 23);
		add(btnMail);
		
		btnProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherHeaderController.viewProfile();
			}
		});
		
		btnCourses.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherHeaderController.viewCourses();
			}
		});
		
		btnMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherHeaderController.viewEmail();
			}
		});
	}
}
