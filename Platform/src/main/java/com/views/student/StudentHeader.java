package com.views.student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.controllers.student.IStudentHeaderController;

public class StudentHeader extends JPanel {
	protected IStudentHeaderController studentHeaderController;
	private JButton btnProfile;
	private JButton btnCourses;
	private JButton btnMail;

	public StudentHeader(IStudentHeaderController studentHeaderController) {
		this.studentHeaderController = studentHeaderController;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		btnProfile = new JButton("Profile");
		btnProfile.setBounds(36, 11, 89, 23);
		add(btnProfile);

		btnCourses = new JButton("Courses");
		btnCourses.setBounds(181, 11, 89, 23);
		add(btnCourses);

		btnMail = new JButton("Mail");
		btnMail.setBounds(329, 11, 89, 23);
		add(btnMail);
		
		btnProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentHeaderController.viewProfile();
			}
		});
		
		btnCourses.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentHeaderController.viewCourses();
			}
		});
		
		btnMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentHeaderController.viewEmail();
			}
		});
	}
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
		  btnProfile.setText(languageBundle.getString("profile"));             
		  btnCourses.setText(languageBundle.getString("courses"));                
		  btnMail.setText(languageBundle.getString("email"));
	  
		}
}
