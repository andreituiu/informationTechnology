package com.views.admin;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ModifyCourses extends JPanel {
	private JTextField nameTextField;
	private JTextField yearTextField;
	private JTextField semesterTextField;
	private JLabel lblName;
	private JLabel lblYear;
	private JLabel lblSemester;
	private JLabel lblTeacher;
	private JLabel lblSpecialization;
	private JComboBox teacherComboBox;
	private JComboBox specializationComboBox;
	private JButton btnAddTeacher;
	public ModifyCourses() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(157, 30, 236, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(157, 134, 236, 19);
		add(yearTextField);
		yearTextField.setColumns(10);
		
		semesterTextField = new JTextField();
		semesterTextField.setBounds(157, 80, 236, 19);
		add(semesterTextField);
		semesterTextField.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setBounds(44, 32, 56, 16);
		add(lblName);
		
		lblYear = new JLabel("Year");
		lblYear.setBounds(44, 136, 56, 16);
		add(lblYear);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(44, 82, 56, 16);
		add(lblSemester);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(220, 291, 116, 25);
		add(btnCreate);
		
		lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(44, 192, 56, 16);
		add(lblTeacher);
		
		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(44, 241, 78, 17);
		add(lblSpecialization);
		
		teacherComboBox = new JComboBox();
		teacherComboBox.setBounds(157, 191, 236, 19);
		add(teacherComboBox);
		
		specializationComboBox = new JComboBox();
		specializationComboBox.setBounds(157, 238, 236, 20);
		add(specializationComboBox);
		
		btnAddTeacher = new JButton("Add teacher");
		btnAddTeacher.setBounds(409, 190, 125, 18);
		add(btnAddTeacher);
	}
}
