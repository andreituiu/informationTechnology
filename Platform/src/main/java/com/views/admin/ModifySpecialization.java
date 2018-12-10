package com.views.admin;

import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ModifySpecialization extends JPanel {

	private JTextField nameTextField;
	private JTextField yearTextField;
	private JTextField semesterTextField;
	
	private JLabel lblSpecializationName;
	private JLabel lblYear;
	private JLabel lblSemester;
	
	private JButton btnSave;
	
	public ModifySpecialization() {
	 initialize();
	}
	public void initialize() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(219, 30, 227, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(219, 77, 227, 22);
		add(yearTextField);
		yearTextField.setColumns(10);
		
		semesterTextField = new JTextField();
		semesterTextField.setBounds(219, 133, 227, 19);
		add(semesterTextField);
		semesterTextField.setColumns(10);
		
		lblSpecializationName = new JLabel("Specialization Name");
		lblSpecializationName.setBounds(62, 32, 121, 16);
		add(lblSpecializationName);
		
		lblYear = new JLabel("Year");
		lblYear.setBounds(62, 80, 56, 16);
		add(lblYear);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(62, 135, 56, 16);
		add(lblSemester);
		
		
		btnSave = new JButton("Save");
		btnSave.setBounds(287, 193, 116, 25);
		add(btnSave);
		
	}
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblSpecializationName.setText(languageBundle.getString("specializationName")); 
	      lblYear.setText(languageBundle.getString("year"));
	      lblSemester.setText(languageBundle.getString("semester"));
	      btnSave.setText(languageBundle.getString("save"));
	  
	  
		}	
}
