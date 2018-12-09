package com.views.teacher;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import org.omg.CORBA.INITIALIZE;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;

import com.model.Course;


public class TeacherFindCoursePannel extends JPanel {

	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnSearch;

	private String[] tableColumns = { "Name", "Specialization"};
	private List<Course> courses;

	public TeacherFindCoursePannel() {
		initialize();
	}

	private void initialize() {
		setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 65, 317, 20);
		add(textField);

		btnSearch = new JButton("Find");
		btnSearch.setBounds(360, 64, 80, 23);
		add(btnSearch);
		
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 108, 157, 263);
		add(scrollPane);
		
		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(tableModel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();

			}
		});
		
			
	}

	public void setLanguageBundle(ResourceBundle languageBundle)  {
	      btnSearch.setText(languageBundle.getString("find"));	  
		}

	
	public void populate(List<Course> courses) {
		eraseTable();
		this.courses = courses;
		for (Course course : courses) {
			Object[] newRow = {course.getName(), course.getSpecialization()};
			tableModel.addRow(newRow);
		}
	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

}
