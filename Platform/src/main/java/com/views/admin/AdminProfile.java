package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminProfile extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public AdminProfile() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 11, 221, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 42, 221, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 73, 221, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 106, 221, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(109, 139, 221, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(109, 269, 221, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(109, 172, 221, 20);
		add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(109, 203, 221, 20);
		add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(109, 236, 221, 20);
		add(textField_8);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(109, 320, 100, 23);
		add(btnSave);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.setBounds(211, 320, 119, 23);
		add(btnChangePassword);
	}
}
