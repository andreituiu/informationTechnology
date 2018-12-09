package com.views.admin;

import java.awt.Dimension;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ManageSpecializations extends JPanel{
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;
	private JButton btnModify;
	private JButton btnCreate;
	
	private String[] tableColumns = {"Name", "Year", "Semester"};
	
	public ManageSpecializations() {
		initialize();
	}
	public void initialize() {
		
		setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);
		
		tablePanel.setLayout(null);
		
		tablePanel.setPreferredSize(new Dimension(536, 246));
		
		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(tableModel);
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(77, 37, 227, 190);
		add(scrollPanel);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setBounds(77, 250, 97, 25);
		add(btnModify);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(211, 250, 97, 25);
		add(btnCreate);
		
	}
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      btnModify.setText(languageBundle.getString("modify"));
	      btnCreate.setText(languageBundle.getString("create"));
	  
	  
		}	

}
