package com.views.admin;
import java.awt.Color;
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
import com.views.common.ILanguagePanel;
import java.awt.Font;

public class CreateCourses extends JFrame implements ILanguagePanel{
	
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
		setSize(800, 500);
		setResizable(false);
	
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(215, 228, 242));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setBounds(224, 27, 354, 31);
		getContentPane().add(courseNameTextField);
		courseNameTextField.setColumns(10);
		
		yearTextField = new JTextField();
		yearTextField.setBounds(224, 137, 354, 31);
		getContentPane().add(yearTextField);
		yearTextField.setColumns(10);
		
		semesterTextField = new JTextField();
		semesterTextField.setBounds(224, 82, 354, 31);
		getContentPane().add(semesterTextField);
		semesterTextField.setColumns(10);
		
		lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseName.setBounds(44, 32, 209, 31);
		getContentPane().add(lblCourseName);
		
		lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYear.setBounds(44, 136, 209, 31);
		getContentPane().add(lblYear);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSemester.setBounds(44, 82, 209, 31);
		getContentPane().add(lblSemester);
		
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(300, 314, 209, 35);
		getContentPane().add(btnSave);
		
		lblTeacher = new JLabel("Teacher");
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeacher.setBounds(44, 192, 209, 31);
		getContentPane().add(lblTeacher);
		
		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialization.setBounds(44, 254, 209, 31);
		getContentPane().add(lblSpecialization);
		
		teacherComboBox = new JComboBox<Teacher>();
		teacherComboBox.setBounds(224, 193, 354, 31);
		getContentPane().add(teacherComboBox);
		
		specializationComboBox = new JComboBox<Specialization>();
		specializationComboBox.setBounds(224, 255, 354, 31);
		getContentPane().add(specializationComboBox);
		
		
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
	
	@Override
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
