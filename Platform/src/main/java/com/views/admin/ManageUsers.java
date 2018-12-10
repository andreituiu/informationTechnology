package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

public class ManageUsers extends JPanel {
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;
	
	private String[] tableColumns = {"Name", "Surname", "CNP", "Role"};
	
	private JButton btnDelete;
	private JButton btnModify;
	private JButton btnCreate;
	private JButton btnSearch;
	
	public ManageUsers() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 42, 299, 22);
		add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(341, 41, 97, 25);
		add(btnSearch);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);
		
		tablePanel.setLayout(null);
		
		tablePanel.setPreferredSize(new Dimension(536, 246));
		
		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(tableModel);
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(10, 69, 299, 190);
		add(scrollPanel);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(12, 262, 97, 25);
		add(btnDelete);
		
		btnModify = new JButton("Modify");
		btnModify.setBounds(121, 262, 97, 25);
		add(btnModify);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(230, 262, 97, 25);
		add(btnCreate);
		
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        
		    }
		});
	}
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      btnModify.setText(languageBundle.getString("modify"));
	      btnCreate.setText(languageBundle.getString("create"));
	      btnDelete.setText(languageBundle.getString("delete"));
	      btnSearch.setText(languageBundle.getString("search"));
	  
		}	
}
