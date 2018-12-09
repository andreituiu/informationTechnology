package com.views.student;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StudentProfileInformationPanel extends JPanel {

	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JTextField specializationTextField;
	private JTextField yearTextField;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;

	public StudentProfileInformationPanel() {
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

		yearTextField = new JTextField();
		yearTextField.setColumns(10);
		yearTextField.setBounds(175, 172, 221, 20);
		add(yearTextField);

		specializationTextField = new JTextField();
		specializationTextField.setColumns(10);
		specializationTextField.setBounds(175, 203, 221, 20);
		add(specializationTextField);

		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		oldPasswordTextField.setBounds(175, 234, 221, 20);
		add(oldPasswordTextField);

		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		newPasswordTextField.setBounds(175, 265, 221, 20);
		add(newPasswordTextField);

		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(175, 296, 221, 20);
		add(confirmPasswordTextField);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(109, 320, 100, 23);
		add(btnSave);

		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.setBounds(211, 320, 119, 23);
		add(btnChangePassword);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(33, 14, 46, 14);
		add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(33, 45, 46, 14);
		add(lblSurname);

		JLabel lblCnp = new JLabel("CNP");
		lblCnp.setBounds(33, 76, 46, 14);
		add(lblCnp);

		JLabel lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setBounds(33, 109, 79, 14);
		add(lblExternalEmail);

		JLabel lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setBounds(33, 142, 79, 14);
		add(lblInternalEmail);

		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(33, 206, 79, 14);
		add(lblSpecialization);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(33, 175, 46, 14);
		add(lblYear);

		JLabel lblOldPassword = new JLabel("Old password");
		lblOldPassword.setBounds(33, 237, 79, 14);
		add(lblOldPassword);

		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(33, 268, 79, 14);
		add(lblNewPassword);

		JLabel lblConfirmationPassword = new JLabel("Confirmation password");
		lblConfirmationPassword.setBounds(33, 299, 119, 14);
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
}