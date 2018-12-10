package com.views.teacher;


import java.util.ResourceBundle;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class TeacherEnrolledStudentsPanel extends JPanel {

	private JTextField textField;
	
	public TeacherEnrolledStudentsPanel() {
		
		initialize();
	}

	private JTextArea txtrEnroledStudents;
	
	private String[] tableColumns = { "Name", "Specialization", "Year"};
	private DefaultTableModel tableModel;
	private JTable table;


	private void initialize() {
		setLayout(null);

		JScrollPane studentsEnrl_scrollPane = new JScrollPane();
		studentsEnrl_scrollPane.setBounds(10, 11, 275, 88);
		txtrEnroledStudents = new JTextArea();
		txtrEnroledStudents.setText("Enroled students");
		studentsEnrl_scrollPane.setColumnHeaderView(txtrEnroledStudents);

		tableModel = new DefaultTableModel(tableColumns, 0);
		
		table = new JTable(tableModel);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentsEnrl_scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();

			}
		});
		add(studentsEnrl_scrollPane);

	}

	
	public void setLanguageBundle(ResourceBundle languageBundle)  {		
			txtrEnroledStudents.setText(languageBundle.getString("enroledStudents"));	  
		}	


	public void populateEnrolledList(List<Student> students) {
		ereaseAll();
		if (students == null || students.isEmpty()) {
			return;
		}
		for (Student student : students) {
			Object[] newRow = {student.getName(), student.getSpecialization(), student.getStudyYear()};
			tableModel.addRow(newRow);
		}

	}

	
	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}
	
	private void ereaseAll() {
		eraseTable();
		txtrEnroledStudents.setText("");
	}
}