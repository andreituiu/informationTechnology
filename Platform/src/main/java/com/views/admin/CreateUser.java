package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class CreateUser extends JPanel {
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblCnp;
	public CreateUser() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(157, 30, 214, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(157, 77, 214, 19);
		add(surnameTextField);
		surnameTextField.setColumns(10);
		
		cnpTextField = new JTextField();
		cnpTextField.setBounds(157, 133, 214, 19);
		add(cnpTextField);
		cnpTextField.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setBounds(12, 33, 56, 16);
		add(lblName);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(12, 80, 56, 16);
		add(lblSurname);
		
		lblCnp = new JLabel("CNP");
		lblCnp.setBounds(12, 136, 56, 16);
		add(lblCnp);
		
		JComboBox spcializationComboBox = new JComboBox();
		spcializationComboBox.setBounds(157, 189, 214, 19);
		add(spcializationComboBox);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(12, 189, 94, 22);
		add(lblSpecialization);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(132, 242, 94, 25);
		add(rdbtnAdmin);
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(230, 242, 104, 25);
		add(rdbtnTeacher);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(338, 242, 127, 25);
		add(rdbtnStudent);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnStudent);
		buttonGroup.add(rdbtnAdmin);
		buttonGroup.add(rdbtnTeacher);
		
		rdbtnStudent.setSelected(true);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(218, 280, 116, 25);
		add(btnCreate);
	}
}
