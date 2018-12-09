package com.views.admin;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CreateSpecialization extends JPanel {

	private JTextField nameTextField;
	private JTextField yearTextField;
	private JTextField semesterTextField;
	private JLabel lblName;
	private JLabel lblYear;
	private JLabel lblSemester;
	public CreateSpecialization() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(157, 30, 227, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(157, 77, 227, 22);
		add(yearTextField);
		yearTextField.setColumns(10);
		
		semesterTextField = new JTextField();
		semesterTextField.setBounds(157, 133, 227, 19);
		add(semesterTextField);
		semesterTextField.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setBounds(62, 32, 56, 16);
		add(lblName);
		
		lblYear = new JLabel("Year");
		lblYear.setBounds(62, 80, 56, 16);
		add(lblYear);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(62, 135, 56, 16);
		add(lblSemester);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(209, 189, 116, 25);
		add(btnCreate);
	}
}
