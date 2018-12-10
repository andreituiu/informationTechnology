package com.views.admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.implementation.AdminCreateCoursesController;
import com.model.Course;
import com.model.Student;

public class ManageCourses extends JPanel{
	
	private JTable table;
	
	private DefaultTableModel tableModel;
	
	private JScrollPane scrollPanel;
	
	private JButton btnModify;
	private JButton btnCreate;
	
	private String[] tableColumns = {"Name", "Teacher", "Year", "Semester", "Specialization"};
	
	private IAdminManageCoursesController adminManageCoursesController;

	private List<Course> coursesList;
	
	
	public ManageCourses(IAdminManageCoursesController adminManageCoursesController) {
		this.adminManageCoursesController = adminManageCoursesController;
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
		scrollPanel.setBounds(12, 26, 374, 200);
		add(scrollPanel);
		
		btnModify = new JButton("Modify");
		btnModify.setBounds(77, 250, 97, 25);
		add(btnModify);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(211, 250, 97, 25);
		add(btnCreate);
		
		
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageCoursesController.openCreateCourseFrame(); 
			}
		});
		
		btnModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageCoursesController.openModifyCourseFrame(); 
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adminManageCoursesController != null) {
					adminManageCoursesController.courseSelected(getSelectedCourse());
				}
			}
		});
	}
	public void setLanguageBundle(ResourceBundle languageBundle)  {
		
	      btnModify.setText(languageBundle.getString("modify"));
	      btnCreate.setText(languageBundle.getString("create"));
	  
	  
		}	
	

	public void populate(List<Course> coursesList) {
	
	ereaseAll();
	if (coursesList == null || coursesList.isEmpty()) {
		return;
	}
	for (Course course : coursesList) {
		Object[] newRow = { course.getName(), course.getTeacher().getName(), course.getYear(), 
				course.getSemester(), course.getSpecialization()};
		tableModel.addRow(newRow);
	}

	}

	private void eraseTable() {
	tableModel.getDataVector().removeAllElements();
	tableModel.fireTableDataChanged();
	}

	private void ereaseAll() {
		eraseTable();
	}

	public Course getSelectedCourse() {
		return coursesList.get(table.getSelectedRow());
	}
}
