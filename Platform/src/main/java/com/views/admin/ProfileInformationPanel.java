package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ProfileInformationPanel extends JPanel{
	private JTextField nameTextField;
	private JTextField SurnameTextField;
	private JTextField CNPTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JTextField specializationTextField;
	private JTextField newPassTextField;
	private JTextField confirmPassTextField;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblCnp;
	private JLabel lblExternalEmail;
	private JLabel lblInternalEmail;
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	private JLabel lblConfirmNewPassword;
	public ProfileInformationPanel() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(269, 13, 221, 20);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		SurnameTextField = new JTextField();
		SurnameTextField.setBounds(269, 44, 221, 20);
		SurnameTextField.setColumns(10);
		add(SurnameTextField);
		
		CNPTextField = new JTextField();
		CNPTextField.setBounds(269, 75, 221, 20);
		CNPTextField.setColumns(10);
		add(CNPTextField);
		
		externalEmailTextField = new JTextField();
		externalEmailTextField.setBounds(269, 108, 221, 20);
		externalEmailTextField.setColumns(10);
		add(externalEmailTextField);
		
		internalEmailTextField = new JTextField();
		internalEmailTextField.setBounds(269, 141, 221, 20);
		internalEmailTextField.setColumns(10);
		add(internalEmailTextField);
		
		specializationTextField = new JTextField();
		specializationTextField.setBounds(269, 271, 221, 20);
		specializationTextField.setColumns(10);
		add(specializationTextField);
		
		newPassTextField = new JTextField();
		newPassTextField.setBounds(269, 205, 221, 20);
		newPassTextField.setColumns(10);
		add(newPassTextField);
		
		confirmPassTextField = new JTextField();
		confirmPassTextField.setBounds(269, 238, 221, 20);
		confirmPassTextField.setColumns(10);
		add(confirmPassTextField);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(154, 320, 100, 23);
		add(btnSave);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.setBounds(292, 320, 186, 23);
		add(btnChangePassword);
		
		lblName = new JLabel("Name");
		lblName.setBounds(81, 15, 56, 16);
		add(lblName);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(81, 46, 56, 16);
		add(lblSurname);
		
		lblCnp = new JLabel("CNP");
		lblCnp.setBounds(81, 77, 56, 16);
		add(lblCnp);
		
		lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setBounds(81, 110, 100, 18);
		add(lblExternalEmail);
		
		lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setBounds(81, 142, 90, 18);
		add(lblInternalEmail);
		
		lblOldPassword = new JLabel("Old password");
		lblOldPassword.setBounds(81, 207, 100, 18);
		add(lblOldPassword);
		
		lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(81, 242, 90, 20);
		add(lblNewPassword);
		
		lblConfirmNewPassword = new JLabel("Confirm new password");
		lblConfirmNewPassword.setBounds(81, 275, 132, 16);
		add(lblConfirmNewPassword);
	}
}
