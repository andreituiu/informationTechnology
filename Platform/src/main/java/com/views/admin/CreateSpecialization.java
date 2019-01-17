package com.views.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateSpecializationsController;
import com.views.common.ILanguagePanel;
import java.awt.Font;
import java.awt.HeadlessException;

@Component
public class CreateSpecialization extends JFrame implements ILanguagePanel{

	private JTextField nameTextField;

	private JLabel lblSpecializationName;
	
	private JButton btnSave;
	
	@Autowired
	private IAdminCreateSpecializationsController adminCreateSpecializationsController;
	
	public CreateSpecialization(IAdminCreateSpecializationsController adminCreateSpecializationsController) {
		
		this.adminCreateSpecializationsController = adminCreateSpecializationsController;
		initialize();
	}
	
	

	public CreateSpecialization() throws HeadlessException {
		super();
	}



	@PostConstruct
	public void initialize() {
		getContentPane().setEnabled(false);
		setSize(1000, 150);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(215, 228, 242));
		
		nameTextField = new JTextField();
		nameTextField.setBounds(232, 30,354, 31);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
 		
		lblSpecializationName = new JLabel("Specialization Name");
		lblSpecializationName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecializationName.setBounds(27, 29, 209, 31);
		getContentPane().add(lblSpecializationName);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(620, 29, 209, 31);
		getContentPane().add(btnSave);
		
	
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminCreateSpecializationsController.saveSpecialization();
			}
		});
	}
	
	@Override
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      lblSpecializationName.setText(languageBundle.getString("specializationName")); 
	  
	      btnSave.setText(languageBundle.getString("save"));
		}	
	
	public String getSpecializationName() {
		return nameTextField.getText();
	}

	
    public void ereaseAll() {
   
	  nameTextField.setText("");
//	  yearTextField.setText("");      
//	  semesterTextField.setText("");  
	        
	
	}
	
	
	
}
