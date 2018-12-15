package com.views.teacher;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.controllers.teacher.ITeacherProfileInformationPanelController;
import com.views.common.ILanguagePanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;

public class TeacherProfileInformationPanel extends JPanel implements ILanguagePanel {

	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JPasswordField oldPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPasswordField confirmPasswordTextField;

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
	private ITeacherProfileInformationPanelController teacherProfileInformationController;

	public TeacherProfileInformationPanel(
			ITeacherProfileInformationPanelController teacherProfileInformationController) {
		this.teacherProfileInformationController = teacherProfileInformationController;
		initialize();
	}

	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		nameTextField = new JTextField();
		nameTextField.setBounds(456, 32, 354, 31);
		nameTextField.setEditable(false);
		add(nameTextField);
		nameTextField.setColumns(10);

		surnameTextField = new JTextField();
		surnameTextField.setBounds(456, 77, 354, 31);
		surnameTextField.setColumns(10);
		surnameTextField.setEditable(false);
		add(surnameTextField);

		cnpTextField = new JTextField();
		cnpTextField.setBounds(456, 121, 354, 31);
		cnpTextField.setColumns(10);
		cnpTextField.setEditable(false);
		add(cnpTextField);

		externalEmailTextField = new JTextField();
		externalEmailTextField.setBounds(456, 160, 354, 31);
		externalEmailTextField.setColumns(10);
		add(externalEmailTextField);

		internalEmailTextField = new JTextField();
		internalEmailTextField.setBounds(456, 205, 354, 31);
		internalEmailTextField.setColumns(10);
		internalEmailTextField.setEditable(false);
		add(internalEmailTextField);

		oldPasswordTextField = new JPasswordField();
		oldPasswordTextField.setColumns(10);
		oldPasswordTextField.setBounds(456, 346, 354, 31);
		add(oldPasswordTextField);

		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setBounds(456, 302, 354, 31);
		newPasswordTextField.setColumns(10);
		add(newPasswordTextField);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setBounds(456, 397, 354, 31);
		confirmPasswordTextField.setColumns(10);
		add(confirmPasswordTextField);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(595, 512, 209, 35);
		add(btnSave);

		btnChangePassword = new JButton("Change password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangePassword.setBounds(595, 455, 209, 35);
		add(btnChangePassword);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(135, 32, 209, 31);
		add(lblName);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(135, 77, 209, 31);
		add(lblSurname);

		lblCnp = new JLabel("CNP");
		lblCnp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCnp.setBounds(135, 121, 209, 31);
		add(lblCnp);

		lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExternalEmail.setBounds(135, 161, 209, 31);
		add(lblExternalEmail);

		lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInternalEmail.setBounds(135, 205, 209, 31);
		add(lblInternalEmail);

		lblOldPassword = new JLabel("Old password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOldPassword.setBounds(135, 345, 209, 31);
		add(lblOldPassword);

		lblNewPassword = new JLabel("New password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewPassword.setBounds(135, 301, 209, 31);
		add(lblNewPassword);

		lblConfirmationPassword = new JLabel("Confirm new password");
		lblConfirmationPassword.setForeground(SystemColor.activeCaptionText);
		lblConfirmationPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConfirmationPassword.setBounds(135, 397, 209, 31);
		add(lblConfirmationPassword);

		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherProfileInformationController.changePassword();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherProfileInformationController.changeSave();
			}
		});
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

	public String getOldPassword() {
		return new String(oldPasswordTextField.getPassword());
	}

	public String getNewPassword() {
		return new String(newPasswordTextField.getPassword());
	}

	public String getConfirmPassword() {
		return new String(confirmPasswordTextField.getPassword());
	}

	public String getExternalEmail() {
		return externalEmailTextField.getText();
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

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

	public void eraseAll() {
		nameTextField.setText("");
		surnameTextField.setText("");
		cnpTextField.setText("");
		internalEmailTextField.setText("");
		externalEmailTextField.setText("");
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
