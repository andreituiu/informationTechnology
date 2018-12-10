package com.views.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.controllers.admin.IAdminCreateUserController;
import com.model.Specialization;

public class CreateUser extends JPanel {
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField cnpTextField;
	
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblCnp;
	private JLabel lblSpecialization;
	
	private JButton btnSave;
	
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnStudent; 
    private JRadioButton rdbtnTeacher;
   
    private JComboBox<Specialization> specializationComboBox;
	
    protected IAdminCreateUserController adminCreateUserController;
	
	public CreateUser(IAdminCreateUserController adminCreateUserController) {
		
		this.adminCreateUserController = adminCreateUserController;
		initialize();
	}
	
	public void initialize() {
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
		
		specializationComboBox = new JComboBox<Specialization>();
		specializationComboBox.setBounds(157, 189, 214, 19);
		add(specializationComboBox);
		
		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(12, 189, 94, 22);
		add(lblSpecialization);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBounds(132, 242, 94, 25);
		add(rdbtnAdmin);
		
		rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(230, 242, 104, 25);
		add(rdbtnTeacher);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(338, 242, 127, 25);
		add(rdbtnStudent);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnStudent);
		buttonGroup.add(rdbtnAdmin);
		buttonGroup.add(rdbtnTeacher);
		
		rdbtnStudent.setSelected(true);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(218, 280, 116, 25);
		add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.saveUser();
			}
		});
		
		rdbtnAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.selectAdmin();
			}
		});
		
		rdbtnStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.selectStudent();
			}
		});
		
		rdbtnTeacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.selectTeacher();
			}
		});
		
		
		
	}
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblName.setText(languageBundle.getString("name"));             
	      lblSurname.setText(languageBundle.getString("surname"));         
	      lblCnp.setText(languageBundle.getString("cnp"));            
	      rdbtnAdmin.setText(languageBundle.getString("admin"));
	      rdbtnStudent.setText(languageBundle.getString("student"));
	      rdbtnTeacher.setText(languageBundle.getString("teacher"));
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
	
	
}
