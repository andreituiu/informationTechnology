package com.views.admin;

import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ModifyCourses extends JPanel {
	
	private JTextField courseNameTextField;
	private JTextField yearTextField;
	private JTextField semesterTextField;
	
	private JLabel lblCourseName;
	private JLabel lblYear;
	private JLabel lblSemester;
	private JLabel lblTeacher;
	private JLabel lblSpecialization;
	
	private JComboBox teacherComboBox;
	private JComboBox specializationComboBox;
	
	private JButton btnAddTeacher;
	private JButton btnSave;
	
	public ModifyCourses() {
		intialize();
	}
	public void intialize() {
		setLayout(null);
		
		courseNameTextField = new JTextField();
		courseNameTextField.setBounds(157, 30, 236, 19);
		add(courseNameTextField);
		courseNameTextField.setColumns(10);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(157, 134, 236, 19);
		add(yearTextField);
		yearTextField.setColumns(10);
		
		semesterTextField = new JTextField();
		semesterTextField.setBounds(157, 80, 236, 19);
		add(semesterTextField);
		semesterTextField.setColumns(10);
		
		lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(44, 32, 78, 19);
		add(lblCourseName);
		
		lblYear = new JLabel("Year");
		lblYear.setBounds(44, 136, 56, 16);
		add(lblYear);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(44, 82, 56, 16);
		add(lblSemester);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		btnSave = new JButton("Save");
		btnSave.setBounds(220, 291, 116, 25);
		add(btnSave);
		
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
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblCourseName.setText(languageBundle.getString("courseName")); 
	      lblYear.setText(languageBundle.getString("year"));
	      lblSemester.setText(languageBundle.getString("semester"));
	      lblTeacher.setText(languageBundle.getString("teacher"));
	      lblSpecialization.setText(languageBundle.getString("specialization"));
	      btnAddTeacher.setText(languageBundle.getString("addTeacher")); 
	      btnSave.setText(languageBundle.getString("save"));
	  
	  
		}	
}
