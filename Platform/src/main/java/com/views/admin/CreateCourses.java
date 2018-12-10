package com.views.admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.controllers.admin.IAdminCreateCoursesController;
import com.model.Specialization;
import com.model.Teacher;

public class CreateCourses extends JFrame {
	
	private JTextField courseNameTextField;
	private JTextField yearTextField;
	private JTextField semesterTextField;
	
	private JLabel lblCourseName;
	private JLabel lblYear;
	private JLabel lblSemester;
	private JLabel lblTeacher;
	private JLabel lblSpecialization;
	
	private JComboBox<Teacher> teacherComboBox;
	private JComboBox<Specialization> specializationComboBox;

	private JButton btnSave;
	
	private IAdminCreateCoursesController adminCreateCoursesController;

 
	
	public CreateCourses(IAdminCreateCoursesController adminCreateCoursesController) {
		this.adminCreateCoursesController = adminCreateCoursesController;

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
		
		
		btnSave = new JButton("Save");
		btnSave.setBounds(220, 291, 116, 25);
		add(btnSave);
		
		lblTeacher = new JLabel("Teacher");
		lblTeacher.setBounds(44, 192, 56, 16);
		add(lblTeacher);
		
		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(44, 241, 78, 17);
		add(lblSpecialization);
		
		teacherComboBox = new JComboBox<Teacher>();
		teacherComboBox.setBounds(157, 191, 236, 19);
		add(teacherComboBox);
		
		specializationComboBox = new JComboBox<Specialization>();
		specializationComboBox.setBounds(157, 238, 236, 20);
		add(specializationComboBox);
		
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateCoursesController.saveCourse();
			}
		});
		
		specializationComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateCoursesController.selectSpecialization((Specialization)specializationComboBox.getSelectedItem());
			};
			});
		
		teacherComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateCoursesController.selectTeacher((Teacher)teacherComboBox.getSelectedItem());
			}
		});
		}
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblCourseName.setText(languageBundle.getString("courseName")); 
	      lblYear.setText(languageBundle.getString("year"));
	      lblSemester.setText(languageBundle.getString("semester"));
	      lblTeacher.setText(languageBundle.getString("teacher"));
	      lblSpecialization.setText(languageBundle.getString("specialization"));
	      btnSave.setText(languageBundle.getString("save"));
	}	
	
	public String getCourseName() {
		return courseNameTextField.getText();
	}


	public Integer getYear() {
	    return new Integer(yearTextField.getText());
	}

	public Integer getSemester() {
	    return new Integer(semesterTextField.getText());
	}

	
    public void ereaseAll() {
    	
	  teacherComboBox.removeAll();
	  specializationComboBox.removeAll();
	  courseNameTextField.setText("");
	  yearTextField.setText("");      
	  semesterTextField.setText("");  
	        
	}

	public void populateTeachers(List<Teacher> teachers) {
		DefaultComboBoxModel<Teacher> model = (DefaultComboBoxModel) teacherComboBox.getModel();
		model.removeAllElements();
		if (teachers == null || teachers.isEmpty()) {
			return;
		}
		
		for (Teacher teacher : teachers) {
		
			teacherComboBox.addItem(teacher);
		}	
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
	
}
