package com.views.common;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Login extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	
	public Login() {
		setLayout(null);
		
		JButton btnLanguageEN = new JButton("EN");
		btnLanguageEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLanguageEN.setBounds(374, 11, 45, 23);
		add(btnLanguageEN);
		
		JButton btnLanguageRO = new JButton("RO");
		btnLanguageRO.setBounds(317, 11, 47, 23);
		add(btnLanguageRO);
		
		textField = new JTextField();
		textField.setBounds(137, 72, 186, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 128, 186, 20);
		add(textField_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(95, 218, 89, 23);
		add(btnLogin);
		
		JButton btnRetrievePassword = new JButton("Retrieve password");
		btnRetrievePassword.setBounds(260, 218, 123, 23);
		add(btnRetrievePassword);
		
		JTextArea txtrUserName = new JTextArea();
		txtrUserName.setBackground(UIManager.getColor("Button.background"));
		txtrUserName.setText("User name");
		txtrUserName.setBounds(51, 70, 76, 22);
		add(txtrUserName);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setText("Password");
		txtrPassword.setBackground(SystemColor.menu);
		txtrPassword.setBounds(51, 126, 76, 22);
		add(txtrPassword);
		
		DefaultListModel listModel = new DefaultListModel();
	}
}
