package com.views.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.controllers.admin.IAdminModifyUserController;
import com.controllers.common.implementation.ROLE;
import com.model.Specialization;
import com.views.common.ILanguagePanel;

public class ModifyUser extends JFrame implements ILanguagePanel {

	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JTextField internalEmailTextField;
	private JTextField externalEmailTextField;
	private JTextField passwordTextField;

	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblCnp;
	private JLabel lblSpecialization;
	private JLabel lblInternalEmail;
	private JLabel lblExternalEmail;
	private JLabel lblPassword;

	private JButton btnSave;

	private JComboBox<Specialization> specializationComboBox;

	protected IAdminModifyUserController adminModifyUserController;
	private JTextField studyYearTextField;
	private JLabel lblStudyYear;

	public ModifyUser(IAdminModifyUserController adminModifyUserController) {
		
		this.adminModifyUserController = adminModifyUserController;
		initialize();
	}

	public void initialize() {
		setSize(800, 600);
		setResizable(false);
		setBackground(new Color(215, 228, 242));
//		setBounds(new Rectangle(0, 0, 209, 31));
//		setResizable(false);
		getContentPane().setLayout(null);

		nameTextField = new JTextField();
		nameTextField.setSize(new Dimension(354, 31));
		nameTextField.setBounds(201, 33, 354, 31);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		surnameTextField = new JTextField();
		surnameTextField.setSize(new Dimension(354, 31));
		surnameTextField.setBounds(201, 76, 354, 31);
		getContentPane().add(surnameTextField);
		surnameTextField.setColumns(10);

		cnpTextField = new JTextField();
		cnpTextField.setBounds(201, 130, 354, 31);
		getContentPane().add(cnpTextField);
		cnpTextField.setColumns(10);

		internalEmailTextField = new JTextField();
		internalEmailTextField.setColumns(10);
		internalEmailTextField.setBounds(201, 173, 354, 31);
		getContentPane().add(internalEmailTextField);

		externalEmailTextField = new JTextField();
		externalEmailTextField.setColumns(10);
		externalEmailTextField.setBounds(201, 212, 354, 31);
		getContentPane().add(externalEmailTextField);

		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(201, 255, 354, 31);
		getContentPane().add(passwordTextField);

		studyYearTextField = new JTextField();
		studyYearTextField.setColumns(10);
		studyYearTextField.setBounds(201, 314, 354, 31);
		getContentPane().add(studyYearTextField);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(new Rectangle(0, 0, 209, 31));
		lblName.setBounds(34, 32, 209, 31);
		getContentPane().add(lblName);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(new Rectangle(0, 0, 209, 31));
		lblSurname.setBounds(34, 77, 209, 31);
		getContentPane().add(lblSurname);

		lblCnp = new JLabel("CNP");
		lblCnp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCnp.setBounds(new Rectangle(0, 0, 209, 31));
		lblCnp.setBounds(34, 129, 209, 31);
		getContentPane().add(lblCnp);

		specializationComboBox = new JComboBox<Specialization>();
		specializationComboBox.setBounds(201, 369, 354, 31);
		getContentPane().add(specializationComboBox);

		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialization.setBounds(new Rectangle(0, 0, 209, 31));
		lblSpecialization.setBounds(34, 368, 209, 31);
		getContentPane().add(lblSpecialization);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(279, 504, 209, 35);
		getContentPane().add(btnSave);

		lblInternalEmail = new JLabel("Internal email");
		lblInternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInternalEmail.setBounds(new Rectangle(0, 0, 209, 31));
		lblInternalEmail.setBounds(34, 172, 209, 31);
		getContentPane().add(lblInternalEmail);

		lblExternalEmail = new JLabel("External email");
		lblExternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExternalEmail.setBounds(new Rectangle(0, 0, 209, 31));
		lblExternalEmail.setBounds(34, 211, 209, 31);
		getContentPane().add(lblExternalEmail);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(new Rectangle(0, 0, 209, 31));
		lblPassword.setBounds(34, 254, 209, 31);
		getContentPane().add(lblPassword);

		lblStudyYear = new JLabel("Study Year");
		lblStudyYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudyYear.setBounds(new Rectangle(0, 0, 209, 31));
		lblStudyYear.setBounds(34, 313, 209, 31);
		getContentPane().add(lblStudyYear);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminModifyUserController.saveUser();
			}
		});

	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		lblName.setText(languageBundle.getString("name"));
		lblSurname.setText(languageBundle.getString("surname"));
		lblCnp.setText(languageBundle.getString("cnp"));
		lblExternalEmail.setText(languageBundle.getString("externalEmail"));
		lblInternalEmail.setText(languageBundle.getString("internalEmail"));
		lblPassword.setText(languageBundle.getString("password"));
		lblStudyYear.setText(languageBundle.getString("year"));
		lblSpecialization.setText(languageBundle.getString("specialization"));
		btnSave.setText(languageBundle.getString("save"));

	}

	public String getName() {
		return nameTextField.getText();
	}

	public String getSurname() {
		return surnameTextField.getText();
	}

	public String getCNP() {
		return cnpTextField.getText();
	}

	public String getInternalEmail() {
		return internalEmailTextField.getText();
	}

	public String getExternalEmail() {
		return externalEmailTextField.getText();
	}

	public String getPassword() {
		return passwordTextField.getText();
	}

	public Integer getStudyYear() {
		return new Integer(studyYearTextField.getText());
	}

	public void ereaseAll() {

		specializationComboBox.removeAll();
		nameTextField.setText("");
		surnameTextField.setText("");
		cnpTextField.setText("");
		studyYearTextField.setText("");
		internalEmailTextField.setText("");
		externalEmailTextField.setText("");
		passwordTextField.setText("");

	}

	public void populateSpecializations(List<Specialization> specializations) {
		DefaultComboBoxModel<Specialization> model = (DefaultComboBoxModel) specializationComboBox.getModel();
		model.removeAllElements();
		if (specializations == null || specializations.isEmpty()) {
			return;
		}

		for (Specialization specialization : specializations) {

			specializationComboBox.addItem(specialization);
		}

	}

	public void setSpecialization(Specialization specialization) {

		for (int i = 0; i < specializationComboBox.getModel().getSize(); i++) {

			if (specializationComboBox.getModel().getElementAt(i).equals(specialization)) {
				specializationComboBox.getModel().setSelectedItem(specialization);
				break;
			}
		}
	}

	public void setName(String name) {
		nameTextField.setText(name);
	}

	public void setSurname(String surname) {
		surnameTextField.setText(surname);
	}

	public void setCnp(String cnp) {
		cnpTextField.setText(cnp);
	}

	private void studentSelected(boolean b) {
		specializationComboBox.setVisible(b);
		studyYearTextField.setVisible(b);
		lblStudyYear.setVisible(b);
		lblSpecialization.setVisible(b);
	}

	public void setExternalEmail(String externalEmail) {
		externalEmailTextField.setText(externalEmail);
	}

	public void setInternalEmail(String internalEmail) {
		internalEmailTextField.setText(internalEmail);
	}

	public void setPassword(String password) {
		passwordTextField.setText(password);
	}

	public void setStudyYear(Integer studyYear) {
		studyYearTextField.setText("" + studyYear);
	}

	public void setRole(ROLE role) {
		if(ROLE.STUDENT == role) {
			studentSelected(true);
		}
		studentSelected(false);
	}
}
