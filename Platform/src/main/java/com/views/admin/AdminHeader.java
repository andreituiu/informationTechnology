package com.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminHeaderController;
import com.views.common.ILanguagePanel;

@Component
public class AdminHeader extends JPanel implements ILanguagePanel {

	private JButton btnManageUsers;
	private JButton btnManageSpecializations;
	private JButton btnManageCourses;
	private JButton btnEmail;
	private JButton btnProfile;

	@Autowired
	private IAdminHeaderController adminHeaderController;

	public AdminHeader() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		btnManageUsers = new JButton("Manage Users");
		btnManageUsers.setForeground(new Color(0, 0, 255));
		btnManageUsers.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnManageUsers.setBounds(176, 13, 187, 35);
		add(btnManageUsers);

		btnManageSpecializations = new JButton("Manage Specializations");
		btnManageSpecializations.setForeground(new Color(0, 0, 255));
		btnManageSpecializations.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnManageSpecializations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageSpecializations.setBounds(375, 13, 219, 35);
		add(btnManageSpecializations);

		btnManageCourses = new JButton("Manage Courses");
		btnManageCourses.setForeground(new Color(0, 0, 255));
		btnManageCourses.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnManageCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageCourses.setBounds(606, 13, 178, 35);
		add(btnManageCourses);

		btnEmail = new JButton("Email");
		btnEmail.setForeground(new Color(0, 0, 255));
		btnEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmail.setBounds(796, 13, 127, 35);
		add(btnEmail);

		btnProfile = new JButton("Profile");
		btnProfile.setForeground(new Color(0, 0, 255));
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProfile.setBounds(12, 13, 152, 35);
		add(btnProfile);

		btnProfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminHeaderController.viewProfile();
			}
		});

		btnManageCourses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminHeaderController.viewCourses();
			}
		});

		btnManageUsers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminHeaderController.viewUsers();
			}
		});

		btnManageSpecializations.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminHeaderController.viewSpecializations();
			}
		});

		btnEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminHeaderController.viewEmail();
			}
		});

	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {
		btnManageUsers.setText(languageBundle.getString("manageUsers"));
		btnManageSpecializations.setText(languageBundle.getString("manageSpecializations"));
		btnManageCourses.setText(languageBundle.getString("manageCourses"));
		btnEmail.setText(languageBundle.getString("email"));
		btnProfile.setText(languageBundle.getString("profile"));
	}
}
