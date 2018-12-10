package com.views.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.controllers.admin.IAdminCreateSpecializationsController;

public class CreateSpecialization extends JFrame {

	private JTextField nameTextField;

	private JLabel lblSpecializationName;
	
	private JButton btnSave;
	
	private IAdminCreateSpecializationsController adminCreateSpecializationsController;
	
	public CreateSpecialization(IAdminCreateSpecializationsController adminCreateSpecializationsController) {
		this.adminCreateSpecializationsController = adminCreateSpecializationsController;
		initialize();
	}
	
	public void initialize() {
		setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(219, 30, 227, 19);
		add(nameTextField);
		nameTextField.setColumns(10);
 		
		lblSpecializationName = new JLabel("Specialization Name");
		lblSpecializationName.setBounds(62, 32, 121, 16);
		add(lblSpecializationName);
		
		btnSave = new JButton("Create");
		btnSave.setBounds(287, 193, 116, 25);
		add(btnSave);
		
	
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateSpecializationsController.saveSpecialization();
			}
		});
	}
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblSpecializationName.setText(languageBundle.getString("specializationName")); 
	  
	      btnSave.setText(languageBundle.getString("save"));
		}	
	
	public String getSpecializationName() {
		return nameTextField.getText();
	}

	
    public void ereaseAll() {
   
	  nameTextField.setText("");
	  yearTextField.setText("");      
	  semesterTextField.setText("");  
	        
	}
	
	
	
}
