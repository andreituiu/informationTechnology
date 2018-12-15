package com.views.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.controllers.admin.IAdminModifySpecializationController;
import com.views.common.ILanguagePanel;
import java.awt.Font;

public class ModifySpecialization extends JFrame implements ILanguagePanel {

	private JTextField nameTextField;

	private JLabel lblSpecializationName;

	private JButton btnSave;

	private IAdminModifySpecializationController adminModifySpecializationController;

	public ModifySpecialization(IAdminModifySpecializationController adminModifySpecializationController) {
		this.adminModifySpecializationController = adminModifySpecializationController;

		initialize();
	}

	public void initialize() {
		setSize(1000, 150);
		getContentPane().setLayout(null);
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameTextField.setBounds(205, 30, 354, 31);
		add(nameTextField);
		nameTextField.setColumns(10);

		lblSpecializationName = new JLabel("Specialization Name");
		lblSpecializationName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecializationName.setBounds(12, 30, 209, 31);
		add(lblSpecializationName);

		btnSave = new JButton("Save");
		btnSave.setBounds(576, 29, 209, 35);
		add(btnSave);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminModifySpecializationController.saveSpecialization();
			}
		});

	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		lblSpecializationName.setText(languageBundle.getString("specializationName"));
		btnSave.setText(languageBundle.getString("save"));

	}

	public void setName(String name) {
		nameTextField.setText(name);
	}
	
	public String getName() {
		return nameTextField.getText();
	}

	public void ereaseAll() {
		nameTextField.setText("");

	}
}
