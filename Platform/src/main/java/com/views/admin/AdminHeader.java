package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHeader extends JPanel{
	public AdminHeader() {
		setLayout(null);
		
		JButton btnManageUsers = new JButton("Manage Users");
		btnManageUsers.setBounds(133, 13, 113, 25);
		add(btnManageUsers);
		
		JButton btnManageSpecializations = new JButton("Manage Specializations");
		btnManageSpecializations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageSpecializations.setBounds(280, 13, 177, 25);
		add(btnManageSpecializations);
		
		JButton btnManageCourses = new JButton("Manage Courses");
		btnManageCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageCourses.setBounds(487, 13, 146, 25);
		add(btnManageCourses);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.setBounds(663, 13, 97, 25);
		add(btnEmail);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(12, 13, 97, 25);
		add(btnProfile);
	}
}
