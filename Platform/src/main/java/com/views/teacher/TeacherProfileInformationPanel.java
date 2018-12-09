package com.views.teacher;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TeacherProfileInformationPanel extends JPanel {

	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblCnp;
	private JLabel lblExternalEmail;
	private JLabel lblInternalEmail;
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	private JLabel lblConfirmationPassword;
	
	private JButton btnSave;
	private JButton btnChangePassword;


	public TeacherProfileInformationPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(null);

		nameTextField = new JTextField();
		nameTextField.setBounds(175, 11, 221, 20);
		add(nameTextField);
		nameTextField.setColumns(10);

		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(175, 42, 221, 20);
		add(surnameTextField);

		cnpTextField = new JTextField();
		cnpTextField.setColumns(10);
		cnpTextField.setBounds(175, 73, 221, 20);
		add(cnpTextField);

		externalEmailTextField = new JTextField();
		externalEmailTextField.setColumns(10);
		externalEmailTextField.setBounds(175, 106, 221, 20);
		add(externalEmailTextField);

		internalEmailTextField = new JTextField();
		internalEmailTextField.setColumns(10);
		internalEmailTextField.setBounds(175, 139, 221, 20);
		add(internalEmailTextField);

		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		oldPasswordTextField.setBounds(175, 170, 221, 20);
		add(oldPasswordTextField);

		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		newPasswordTextField.setBounds(175, 201, 221, 20);
		add(newPasswordTextField);

		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(175, 232, 221, 20);
		add(confirmPasswordTextField);

	    btnSave = new JButton("Save");
		btnSave.setBounds(110, 283, 100, 23);
		add(btnSave);

		btnChangePassword = new JButton("Change password");
		btnChangePassword.setBounds(220, 283, 119, 23);
		add(btnChangePassword);

		lblName = new JLabel("Name");
		lblName.setBounds(33, 14, 46, 14);
		add(lblName);

		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(33, 45, 46, 14);
		add(lblSurname);

		lblCnp = new JLabel("CNP");
		lblCnp.setBounds(33, 76, 46, 14);
		add(lblCnp);

		lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setBounds(33, 109, 79, 14);
		add(lblExternalEmail);

		lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setBounds(33, 142, 79, 14);
		add(lblInternalEmail);

		lblOldPassword = new JLabel("Old password");
		lblOldPassword.setBounds(33, 173, 79, 14);
		add(lblOldPassword);

		lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(33, 204, 79, 14);
		add(lblNewPassword);

		lblConfirmationPassword = new JLabel("Confirm password");
		lblConfirmationPassword.setBounds(33, 235, 119, 14);
		add(lblConfirmationPassword);
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
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblName.setText(languageBundle.getString("name"));             
	      lblSurname.setText(languageBundle.getString("surname"));         
	      lblCnp.setText(languageBundle.getString("cnp"));            
	      lblExternalEmail.setText(languageBundle.getString("externalEmail"));
	      lblInternalEmail.setText(languageBundle.getString("internalEmail"));
	      lblOldPassword.setText(languageBundle.getString("oldPassword"));
	      lblNewPassword.setText(languageBundle.getString("newPassword"));
	      lblConfirmationPassword.setText(languageBundle.getString("confirmPassword"));
	      btnSave.setText(languageBundle.getString("save"));
	      btnChangePassword.setText(languageBundle.getString("changePassword"));
		}
}
