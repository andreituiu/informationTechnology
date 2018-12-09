package com.views.student;

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

import com.controllers.student.IStudentFindCoursePannelController;
import com.model.Course;


public class StudentFindCoursePannel extends JPanel {

	private JTextField searchTextField;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;
	private JButton btnSearch;
	private JButton btnEnrole;

	private String[] tableColumns = { "Enrolled", "Course name", "Teacher name", "Specialization" };
	private List<Course> courses;
	protected IStudentFindCoursePannelController studentFindCoursesController;

	public StudentFindCoursePannel(IStudentFindCoursePannelController studentFindCoursesController) {
		this.studentFindCoursesController = studentFindCoursesController;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		searchTextField = new JTextField();
		searchTextField.setBounds(10, 11, 317, 20);
		add(searchTextField);
		searchTextField.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(360, 10, 80, 23);
		add(btnSearch);

		btnEnrole = new JButton("Enrole");
		btnEnrole.setBounds(360, 146, 80, 23);
		add(btnEnrole);

		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);

		tablePanel.setLayout(null);

		tablePanel.setPreferredSize(new Dimension(536, 246));

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(tableModel);
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(10, 69, 317, 220);
		add(scrollPanel);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();

			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentFindCoursesController.searchCourse();
			}
		});
		
			
	}

	public void setLanguageBundle(ResourceBundle languageBundle)  {
		  btnEnrole.setText(languageBundle.getString("enrole"));
	      btnSearch.setText(languageBundle.getString("search"));
	  
		}

	
	public void populate(List<Course> courses) {
		eraseTable();
		this.courses = courses;
		for (Course course : courses) {
			Object[] newRow = {"", course.getName(), course.getSpecialization(), course.getTeacher().getName()};
			tableModel.addRow(newRow);
		}
	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	public String getSearchedText() {
		return searchTextField.getText();
	}

}
