package com.views.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.common.ILanguageController;
import com.controllers.common.ILoginController;

@Component
public class Login extends JFrame implements ILanguagePanel {
	private JTextField textField;
	private JPasswordField passwordTextField;
	private JButton btnLogin;
	private JButton btnLanguageEN;
	private JButton btnLanguageRO;
	private JButton btnRetrievePassword;
	private JLabel txtrPassword;
	private JLabel txtrUserName;

	@Autowired
	private ILanguageController languageController;

	@Autowired
	private ILoginController loginController;
	private ResourceBundle languageBundle;

	public Login(ILoginController loginController, ILanguageController languageController) {
		setResizable(false);
		this.loginController = loginController;
		this.languageController = languageController;
		initialize();

	}

	public Login() throws HeadlessException {
		super();
	}

	@PostConstruct
	public void initialize() {
		setSize(1000, 500);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(215, 228, 242));
		setBackground(new Color(215, 228, 242));

		btnLanguageEN = new JButton("EN");
		btnLanguageEN.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLanguageEN.setForeground(new Color(0, 0, 0));

		btnLanguageEN.setBounds(830, 11, 61, 35);
		add(btnLanguageEN);

		btnLanguageRO = new JButton("RO");
		btnLanguageRO.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLanguageRO.setForeground(new Color(0, 0, 0));
		btnLanguageRO.setBounds(757, 11, 61, 35);
		add(btnLanguageRO);

		textField = new JTextField();
		textField.setBounds(287, 133, 400, 40);
		add(textField);
		textField.setColumns(10);

		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(287, 239, 400, 40);
		add(passwordTextField);

		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 102, 204));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(366, 324, 209, 35);
		add(btnLogin);

		btnRetrievePassword = new JButton("Retrieve password");
		btnRetrievePassword.setForeground(new Color(0, 0, 0));
		btnRetrievePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRetrievePassword.setBounds(699, 241, 209, 35);
		add(btnRetrievePassword);

		txtrUserName = new JLabel();
		txtrUserName.setForeground(UIManager.getColor("Viewport.foreground"));
		txtrUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrUserName.setBackground(UIManager.getColor("Button.background"));
		txtrUserName.setText("CNP");
		txtrUserName.setBounds(55, 133, 209, 39);
		add(txtrUserName);

		txtrPassword = new JLabel();
		txtrPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrPassword.setText("Password");
		txtrPassword.setBackground(SystemColor.menu);
		txtrPassword.setBounds(55, 239, 209, 39);
		add(txtrPassword);

		btnLanguageRO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				languageController.roLanguageSelected();
			}
		});

		btnLanguageEN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				languageController.enLanguageSelected();
			}
		});

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginController.login();
			}
		});
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		this.languageBundle = languageBundle;
		btnLogin.setText(languageBundle.getString("login"));
		btnLanguageEN.setText(languageBundle.getString("languageEN"));
		btnLanguageRO.setText(languageBundle.getString("languageRO"));
		btnRetrievePassword.setText(languageBundle.getString("retrievePassword"));
		txtrPassword.setText(languageBundle.getString("password"));
		txtrUserName.setText(languageBundle.getString("cnp"));

	}

	public String getUserCnp() {
		return textField.getText();
	}

	public String getPassword() {
		return new String(passwordTextField.getPassword());
	}

	public ResourceBundle getLanguageBundle() {
		return languageBundle;
	}

	public void showPopup(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	
}
