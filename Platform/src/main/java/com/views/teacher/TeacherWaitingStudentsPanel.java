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
import com.views.common.ILanguagePanel;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class TeacherWaitingStudentsPanel extends JPanel implements ILanguagePanel {

	private JTextField textField;

	public TeacherWaitingStudentsPanel() {

		initialize();
	}

	private JTextArea txtrWaitingStudents;

	private String[] tableColumns = { "Name", "Specialization", "Year" };
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextArea txtrStudentsWaitingFor;

	private void initialize() {
		setLayout(null);

		JScrollPane studentsWaiting_scrollPane = new JScrollPane();
		studentsWaiting_scrollPane.setBounds(10, 11, 302, 218);
		txtrStudentsWaitingFor = new JTextArea();
		txtrStudentsWaitingFor.setText("Students waiting for confimation");
		studentsWaiting_scrollPane.setColumnHeaderView(txtrStudentsWaitingFor);

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(tableModel);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		studentsWaiting_scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				JTable table = (JTable) me.getSource();
				Point p = me.getPoint();

			}
		});

	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {
		txtrStudentsWaitingFor.setText(languageBundle.getString("studentsWaitingForConfimation"));
	}

	public void populateWaitingList(List<Student> students) {
		ereaseAll();
		if (students == null || students.isEmpty()) {
			return;
		}
		for (Student student : students) {
			Object[] newRow = { student.getName(), student.getSpecialization(), student.getStudyYear() };
			tableModel.addRow(newRow);
		}

	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	private void ereaseAll() {
		eraseTable();
		txtrWaitingStudents.setText("");
	}
}