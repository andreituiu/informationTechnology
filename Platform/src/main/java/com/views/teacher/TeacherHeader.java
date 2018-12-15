package com.views.teacher;

import javax.swing.JPanel;

import com.controllers.teacher.ITeacherHeaderController;
import com.views.common.ILanguagePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;

public class TeacherHeader extends JPanel implements ILanguagePanel{
	protected ITeacherHeaderController teacherHeaderController;
	private JButton btnProfile;
	private JButton btnCourses;
	private JButton btnMail;

	public TeacherHeader(ITeacherHeaderController teacherHeaderController) {
		this.teacherHeaderController = teacherHeaderController;
		initialize();
	}

	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		btnProfile = new JButton("Profile");
		btnProfile.setForeground(new Color(0, 0, 255));
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProfile.setBounds(75, 13, 152, 35);
		add(btnProfile);

		btnCourses = new JButton("Courses");
		btnCourses.setForeground(new Color(0, 0, 255));
		btnCourses.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCourses.setBounds(367, 13, 152, 35);
		add(btnCourses);

		btnMail = new JButton("Email");
		btnMail.setBounds(625, 13, 152, 35);
		btnMail.setForeground(new Color(0, 0, 255));
		btnMail.setFont(new Font("Tahoma", Font.BOLD, 15));
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
	
	@Override
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
		  btnProfile.setText(languageBundle.getString("profile"));             
		  btnCourses.setText(languageBundle.getString("courses"));                
		  btnMail.setText(languageBundle.getString("email"));
	  
		}
}
