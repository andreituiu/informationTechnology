package com.views.teacher;

import java.awt.Color;
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
import com.views.common.ILanguagePanel;
import java.awt.Font;


public class TeacherFindCoursePannel extends JPanel implements ILanguagePanel{

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
		setBackground(new Color(215, 228, 242));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 65, 305, 31);
		add(textField);

		btnSearch = new JButton("Find");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(327, 63, 209, 35);
		add(btnSearch);
		
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(10, 108, 305, 263);
		add(scrollPane);
		
		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(tableModel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();

			}
		});
		
			
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle)  {
	      btnSearch.setText(languageBundle.getString("find"));	  
		}

	
	public void populate(List<Course> courses) {
		eraseTable();
		this.courses = courses;
		for (Course course : courses) {
			Object[] newRow = {course.getName()};
			tableModel.addRow(newRow);
		}
		table.setModel(tableModel);
	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

}
