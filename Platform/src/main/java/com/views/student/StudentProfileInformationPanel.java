package com.views.student;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.controllers.student.IStudentProfileInformationPanelController;
import com.model.Specialization;
import com.views.common.ILanguagePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StudentProfileInformationPanel extends JPanel implements ILanguagePanel {

	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JTextField specializationTextField;
	private JTextField yearTextField;
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
	private JLabel lblSpecialization;
	private JLabel lblYear;

	private JButton btnSave;
	private JButton btnChangePassword;
	private IStudentProfileInformationPanelController studentProfileInformationController;

	public StudentProfileInformationPanel() {
		initialize();
	}

	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		nameTextField = new JTextField();
		nameTextField.setBounds(232, 6, 354, 31);
		nameTextField.setColumns(10);
		nameTextField.setEditable(false);
		add(nameTextField);

		surnameTextField = new JTextField();
		surnameTextField.setBounds(232, 50, 354, 31);
		surnameTextField.setColumns(10);
		surnameTextField.setEditable(false);
		add(surnameTextField);

		cnpTextField = new JTextField();
		cnpTextField.setBounds(232, 90, 354, 31);
		cnpTextField.setColumns(10);
		cnpTextField.setEditable(false);
		add(cnpTextField);

		externalEmailTextField = new JTextField();
		externalEmailTextField.setBounds(232, 134, 354, 31);
		externalEmailTextField.setColumns(10);
		add(externalEmailTextField);

		internalEmailTextField = new JTextField();
		internalEmailTextField.setBounds(232, 178, 354, 31);
		internalEmailTextField.setColumns(10);
		internalEmailTextField.setEditable(false);
		add(internalEmailTextField);

		yearTextField = new JTextField();
		yearTextField.setColumns(10);
		yearTextField.setBounds(232, 222, 354, 31);
		yearTextField.setEditable(false);
		add(yearTextField);

		specializationTextField = new JTextField();
		specializationTextField.setColumns(10);
		specializationTextField.setBounds(232, 266, 354, 31);
		specializationTextField.setEditable(false);
		add(specializationTextField);

		oldPasswordTextField = new JPasswordField();
		oldPasswordTextField.setColumns(10);
		oldPasswordTextField.setBounds(232, 341, 354, 31);
		add(oldPasswordTextField);

		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setBounds(232, 392, 354, 31);
		newPasswordTextField.setColumns(10);
		add(newPasswordTextField);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setBounds(232, 445, 354, 31);
		confirmPasswordTextField.setColumns(10);
		add(confirmPasswordTextField);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(182, 489, 209, 35);
		add(btnSave);

		btnChangePassword = new JButton("Change password");
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangePassword.setBounds(438, 489, 209, 35);
		add(btnChangePassword);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(43, 5, 209, 31);
		add(lblName);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(43, 50, 209, 31);
		add(lblSurname);

		lblCnp = new JLabel("CNP");
		lblCnp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCnp.setBounds(43, 94, 209, 31);
		add(lblCnp);

		lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExternalEmail.setBounds(43, 134, 209, 31);
		add(lblExternalEmail);

		lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInternalEmail.setBounds(43, 178, 209, 31);
		add(lblInternalEmail);

		lblOldPassword = new JLabel("Old password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOldPassword.setBounds(43, 384, 209, 31);
		add(lblOldPassword);

		lblNewPassword = new JLabel("New password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewPassword.setBounds(43, 340, 209, 31);
		add(lblNewPassword);

		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialization.setBounds(43, 264, 209, 31);
		add(lblSpecialization);

		lblYear = new JLabel("Year Study");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYear.setBounds(43, 220, 209, 31);
		add(lblYear);

		lblConfirmationPassword = new JLabel("Confirm new password");
		lblConfirmationPassword.setForeground(SystemColor.activeCaptionText);
		lblConfirmationPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConfirmationPassword.setBounds(43, 436, 209, 31);
		add(lblConfirmationPassword);
		
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentProfileInformationController.changePassword();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentProfileInformationController.changeSave();
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

	public void setYearStudy(int studyYear) {
		yearTextField.setText("" + studyYear);
	}

	public void setSpecialization(Specialization specialization) {
		try {
			specializationTextField.setText(specialization.getName());
		} catch (Exception e) {
		}
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
		lblYear.setText(languageBundle.getString("year"));
		lblSpecialization.setText(languageBundle.getString("specialization"));
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
		yearTextField.setText("");
		specializationTextField.setText("");
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
