package com.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminProfileController;
import com.views.common.ILanguagePanel;

@Component(value = "adminProfile")
public class AdminProfile extends JPanel implements ILanguagePanel {
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField externalEmailTextField;
	private JTextField internalEmailTextField;
	private JPasswordField oldPassTextField;
	private JPasswordField newPassTextField;
	private JPasswordField confirmPasswordTextField;

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

	@Autowired
	private IAdminProfileController adminProfileController;
	private ResourceBundle languageBundle;

	public AdminProfile(IAdminProfileController adminProfileController) {

		this.adminProfileController = adminProfileController;
		initialize();
	}

	public AdminProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		nameTextField = new JTextField();
		nameTextField.setBounds(269, 57, 354, 31);
		add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setEditable(false);

		surnameTextField = new JTextField();
		surnameTextField.setBounds(269, 101, 354, 31);
		surnameTextField.setColumns(10);
		surnameTextField.setEditable(false);
		add(surnameTextField);

		cnpTextField = new JTextField();
		cnpTextField.setBounds(269, 145, 354, 31);
		cnpTextField.setColumns(10);
		cnpTextField.setEditable(false);
		add(cnpTextField);

		externalEmailTextField = new JTextField();
		externalEmailTextField.setBounds(269, 189, 354, 31);
		externalEmailTextField.setColumns(10);
		add(externalEmailTextField);

		internalEmailTextField = new JTextField();
		internalEmailTextField.setBounds(269, 233, 354, 31);
		internalEmailTextField.setColumns(10);
		internalEmailTextField.setEditable(false);
		add(internalEmailTextField);

		oldPassTextField = new JPasswordField();
		oldPassTextField.setBounds(269, 335, 354, 31);
		oldPassTextField.setColumns(10);
		add(oldPassTextField);

		newPassTextField = new JPasswordField();
		newPassTextField.setBounds(269, 389, 354, 31);
		newPassTextField.setColumns(10);
		add(newPassTextField);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setForeground(SystemColor.activeCaptionText);
		btnSave.setBounds(207, 513, 209, 35);
		add(btnSave);

		btnChangePassword = new JButton("Change password");
		btnChangePassword.setForeground(SystemColor.activeCaptionText);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangePassword.setBounds(489, 513, 209, 35);
		add(btnChangePassword);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(58, 56, 209, 31);
		add(lblName);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(58, 101, 209, 31);
		add(lblSurname);

		lblCnp = new JLabel("CNP");
		lblCnp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCnp.setBounds(58, 144, 209, 31);
		add(lblCnp);

		lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExternalEmail.setBounds(58, 188, 209, 31);
		add(lblExternalEmail);

		lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInternalEmail.setBounds(58, 233, 209, 31);
		add(lblInternalEmail);

		lblOldPassword = new JLabel("Old password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOldPassword.setBounds(59, 341, 209, 31);
		add(lblOldPassword);

		lblNewPassword = new JLabel("New password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewPassword.setBounds(59, 388, 209, 31);
		add(lblNewPassword);

		lblConfirmNewPassword = new JLabel("Confirm new password");
		lblConfirmNewPassword.setForeground(SystemColor.activeCaptionText);
		lblConfirmNewPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConfirmNewPassword.setBounds(59, 436, 209, 31);
		add(lblConfirmNewPassword);

		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(269, 437, 354, 31);
		add(confirmPasswordTextField);

		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminProfileController.changePassword();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminProfileController.changeSave();
			}
		});
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		this.languageBundle = languageBundle;
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
	
	public void showPopup(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	public ResourceBundle getLanguageBundle() {
		return languageBundle;
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
		oldPassTextField.setText("");
		confirmPasswordTextField.setText("");
		newPassTextField.setText("");
	}

	public String getOldPassword() {
		return new String(oldPassTextField.getPassword());
	}

	public String getNewPassword() {
		return new String(newPassTextField.getPassword());
	}

	public String getConfirmPassword() {
		return new String(confirmPasswordTextField.getPassword());
	}

	public String getExternalEmail() {
		return externalEmailTextField.getText();
	}
}
