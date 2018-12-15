package com.views.admin;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.controllers.admin.IAdminCreateUserController;
import com.model.Assignment;
import com.model.Specialization;
import javax.swing.JList;

public class CreateUser extends JFrame {
	
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
	
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnStudent; 
    private JRadioButton rdbtnTeacher;
   
    private JComboBox<Specialization> specializationComboBox;
	
    protected IAdminCreateUserController adminCreateUserController;
    private JTextField studyYearTextField;
    private JLabel lblStudyYear;
   
 
   
	
	public CreateUser(IAdminCreateUserController adminCreateUserController) {
		
		this.adminCreateUserController = adminCreateUserController;
		setBackground(new Color(215, 228, 242));
		initialize();
	}
	
	public void initialize() {
		setSize(800, 600);
		setResizable(false);
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField = new JTextField();
		nameTextField.setBounds(269, 57, 354, 31);
		add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setBounds(269, 101, 354, 31);
		surnameTextField.setColumns(10);
		add(surnameTextField);
		
		cnpTextField = new JTextField();
		cnpTextField.setBounds(269, 145, 354, 31);
		cnpTextField.setColumns(10);
		add(cnpTextField);
		
		externalEmailTextField = new JTextField();
		externalEmailTextField.setBounds(269, 189, 354, 31);
		externalEmailTextField.setColumns(10);
		add(externalEmailTextField);
		
		internalEmailTextField = new JTextField();
		internalEmailTextField.setBounds(269, 240, 354, 31);
		internalEmailTextField.setColumns(10);
		add(internalEmailTextField);

		studyYearTextField = new JTextField();
		studyYearTextField.setColumns(10);
		studyYearTextField.setBounds(269, 326,354, 31);
		add(studyYearTextField);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
		lblName.setBounds(48, 56, 209, 31);
		add(lblName);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
		lblSurname.setBounds(48, 100, 209, 31);
		add(lblSurname);
		
		lblCnp = new JLabel("CNP");
		lblCnp.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
		lblCnp.setBounds(48, 144, 209, 31);
		add(lblCnp);
		
		specializationComboBox = new JComboBox<Specialization>();
		specializationComboBox.setBounds(269, 370, 354, 31);
		add(specializationComboBox);
		
		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
		lblSpecialization.setBounds(48, 369, 209, 31);                 
		add(lblSpecialization);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnAdmin.setBounds(279, 410, 116, 31);
		add(rdbtnAdmin);
		
		rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(399, 411, 104, 31);
		add(rdbtnTeacher);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(507, 411, 116, 31);
		add(rdbtnStudent);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnStudent);
		buttonGroup.add(rdbtnAdmin);
		buttonGroup.add(rdbtnTeacher);
		
		rdbtnStudent.setSelected(true);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(360, 474, 209, 35);
		add(btnSave);
		
		lblExternalEmail = new JLabel("External e-mail");
		lblExternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExternalEmail.setBounds(48, 189, 209, 31);
		add(lblExternalEmail);
		
		lblInternalEmail = new JLabel("Internal e-mail");
		lblInternalEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInternalEmail.setBounds(48, 239, 209, 31);
		add(lblInternalEmail);
		
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(48, 283, 209, 31);
		add(lblPassword);
		
		
		lblStudyYear = new JLabel("Study Year");
		lblStudyYear.setBounds(48, 326, 209, 31);
		add(lblStudyYear);
		
		passwordTextField = new JTextField();
		passwordTextField.setBounds(269, 284, 354, 31);
		add(passwordTextField);
		passwordTextField.setColumns(10);
		
	
		
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
				studentSelected(false);
			}
		});
		
		rdbtnStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.selectStudent();
				studentSelected(true);
			}
		});
		
		rdbtnTeacher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.selectTeacher();
				studentSelected(false);
			}
		});
		
		specializationComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateUserController.selectSpecialization((Specialization)specializationComboBox.getSelectedItem());
			};
			});
		
		
		
		
	}
	
	private void studentSelected(boolean b) {
		specializationComboBox.setVisible(b);
		studyYearTextField.setVisible(b);
		lblSpecialization.setVisible(b);
		lblStudyYear.setVisible(b);
	}
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblName.setText(languageBundle.getString("name"));             
	      lblSurname.setText(languageBundle.getString("surname"));         
	      lblCnp.setText(languageBundle.getString("cnp"));    
	      lblExternalEmail.setText(languageBundle.getString("externalEmail"));  
	      lblInternalEmail.setText(languageBundle.getString("internalEmail"));  
	      lblPassword.setText(languageBundle.getString("password")); 
	      lblStudyYear.setText(languageBundle.getString("year")); 
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
		// TODO Auto-generated method stub
		return new Integer (studyYearTextField.getText());
	}
	
	  public void ereaseAll() {
	    	
		  specializationComboBox.removeAll();
		  nameTextField.setText("");
		  surnameTextField.setText("");      
		  cnpTextField.setText("");  
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
		
		adminCreateUserController.selectSpecialization((Specialization) specializationComboBox
	                .getSelectedItem());
	}
}
