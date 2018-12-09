package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class AdminHeader extends JPanel{
	private JButton btnManageUsers;
	private JButton btnManageSpecializations;
	private JButton btnManageCourses;
	private JButton btnEmail;
	private JButton btnProfile;
	
	public AdminHeader() {
		initialize();
	}
	
	private void initialize() {
		setLayout(null);
		
		btnManageUsers = new JButton("Manage Users");
		btnManageUsers.setBounds(133, 13, 113, 25);
		add(btnManageUsers);
		
		btnManageSpecializations = new JButton("Manage Specializations");
		btnManageSpecializations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageSpecializations.setBounds(280, 13, 177, 25);
		add(btnManageSpecializations);
		
		btnManageCourses = new JButton("Manage Courses");
		btnManageCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageCourses.setBounds(487, 13, 146, 25);
		add(btnManageCourses);
		
		btnEmail = new JButton("Email");
		btnEmail.setBounds(663, 13, 97, 25);
		add(btnEmail);
		
		btnProfile = new JButton("Profile");
		btnProfile.setBounds(12, 13, 97, 25);
		add(btnProfile);
	}
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		btnManageUsers.setText(languageBundle.getString("manageUsers"));
		btnManageSpecializations.setText(languageBundle.getString("manageSpecializations"));
		btnManageCourses.setText(languageBundle.getString("manageCourses"));
		btnEmail.setText(languageBundle.getString("email"));
		btnProfile.setText(languageBundle.getString("profile"));
	}
}
