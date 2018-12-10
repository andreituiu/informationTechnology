package com.views.teacher;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.controllers.teacher.implementation.TeacherManageAssignmentsPanelController;
import com.model.Student;

public class TeacherStudentsTablePanel extends JPanel {

	private String[] tableColumns = { "Name", "Surname", "Specialization", "Year" };
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextArea txtrStudentsWaitingFor;

	private List<Student> students;

	private ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController = null;

	public TeacherStudentsTablePanel() {
		super();
		initialize();
	}

	public TeacherStudentsTablePanel(ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController) {
		super();
		this.teacherManageAssignmentsPanelController = teacherManageAssignmentsPanelController;
		initialize();
	}

	private void initialize() {
		setLayout(null);

		JScrollPane studentsWaiting_scrollPane = new JScrollPane();
		studentsWaiting_scrollPane.setBounds(0, 0, 302, 111);
		txtrStudentsWaitingFor = new JTextArea();
		txtrStudentsWaitingFor.setText("Students waiting for confimation");
		studentsWaiting_scrollPane.setColumnHeaderView(txtrStudentsWaitingFor);

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(tableModel);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		studentsWaiting_scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (teacherManageAssignmentsPanelController != null) {
					teacherManageAssignmentsPanelController.studentSelected(getSelectedStudent());
				}
			}
		});

		add(studentsWaiting_scrollPane);
	}

	public void setLanguageBundle(ResourceBundle languageBundle) {
	}

	public void populate(List<Student> students) {
		this.students = students;
		ereaseAll();
		if (students == null || students.isEmpty()) {
			return;
		}
		for (Student student : students) {
			Object[] newRow = { student.getName(), student.getSurname(), student.getSpecialization(),
					student.getStudyYear() };
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

	public Student getSelectedStudent() {
		return students.get(table.getSelectedRow());
	}

}