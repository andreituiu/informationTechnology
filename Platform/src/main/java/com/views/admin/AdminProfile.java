package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;

public class AdminProfile extends JPanel{
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JTextField newPassTextField;
	private JTextField confirmPassTextField;
	private JTextField confirmPasswordTextField;
	
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblCnp;
	private JLabel lblExternalEmail;
	private JLabel lblInternalEmail;
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	private JLabel lblConfirmNewPassword;
	
	private JButton btnSave;
	private JButton btnChangePassword;
	
	public AdminProfile() {
		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(269, 13, 221, 20);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(269, 44, 221, 20);
		surnameTextField.setColumns(10);
		add(surnameTextField);
		
		cnpTextField = new JTextField();
		cnpTextField.setBounds(269, 75, 221, 20);
		cnpTextField.setColumns(10);
		add(cnpTextField);
		
		externalEmailTextField = new JTextField();
		externalEmailTextField.setBounds(269, 108, 221, 20);
		externalEmailTextField.setColumns(10);
		add(externalEmailTextField);
		
		internalEmailTextField = new JTextField();
		internalEmailTextField.setBounds(269, 141, 221, 20);
		internalEmailTextField.setColumns(10);
		add(internalEmailTextField);
		
		
		newPassTextField = new JTextField();
		newPassTextField.setBounds(269, 205, 221, 20);
		newPassTextField.setColumns(10);
		add(newPassTextField);
		
		confirmPassTextField = new JTextField();
		confirmPassTextField.setBounds(269, 238, 221, 20);
		confirmPassTextField.setColumns(10);
		add(confirmPassTextField);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(154, 320, 100, 23);
		add(btnSave);
		
		btnChangePassword = new JButton("Change password");
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
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(269, 272, 221, 20);
		add(confirmPasswordTextField);
	}  
	public void setLanguageBundle(ResourceBundle languageBundle)  {
	
      lblName.setText(languageBundle.getString("name"));             
      lblSurname.setText(languageBundle.getString("surname"));         
      lblCnp.setText(languageBundle.getString("cnp"));            
      lblExternalEmail.setText(languageBundle.getString("externalEmail"));
      lblInternalEmail.setText(languageBundle.getString("internalEmail"));
      lblOldPassword.setText(languageBundle.getString("oldPassword"));
      lblNewPassword.setText(languageBundle.getString("newPassword"));
      lblConfirmNewPassword.setText(languageBundle.getString("confirmPassword"));
      btnSave.setText(languageBundle.getString("save"));
      btnChangePassword.setText(languageBundle.getString("changePassword"));
	}	
	
	public void setUsername(String name) {
		nameTextField.setText(name);
	}

	public void setSurname(String surname) {
		surnameTextField.setText(surname);
	}

	public void setCNP(String cnp) {
		cnpTextField.setText(cnp);
	}
	
	public void setExternalEmail(String externalEmail) {
		externalEmailTextField.setText(externalEmail);
	}
	
	
	public void setInternalEmail(String internalEmail) {
		internalEmailTextField.setText(internalEmail);
	}
	
	public void ereaseAll() {
		
		nameTextField.setText("");
		surnameTextField.setText("");	
		cnpTextField.setText("");	
		externalEmailTextField.setText("");
		internalEmailTextField.setText("");             
	}
}
