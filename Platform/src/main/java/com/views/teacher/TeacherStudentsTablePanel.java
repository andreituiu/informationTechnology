package com.views.teacher;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.model.Student;
import com.views.common.ILanguagePanel;

@Component
@Scope(value="prototype")
public class TeacherStudentsTablePanel extends JPanel implements ILanguagePanel{

	private String[] tableColumns = { "Name", "Surname", "Specialization", "Year" };
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextArea txtrStudentsWaitingFor;

	private List<Student> students;

	@Autowired
	private ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController;

	public TeacherStudentsTablePanel(ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController) {
		super();
		this.teacherManageAssignmentsPanelController = teacherManageAssignmentsPanelController;
		initialize();
	}
	
	public TeacherStudentsTablePanel() {
		super();
	}

	@PostConstruct
	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		JScrollPane studentsWaiting_scrollPane = new JScrollPane();
		studentsWaiting_scrollPane.setBounds(26, 13, 509, 163);
		txtrStudentsWaitingFor = new JTextArea();
		txtrStudentsWaitingFor.setText("Students waiting for confimation");
		studentsWaiting_scrollPane.setColumnHeaderView(txtrStudentsWaitingFor);

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(tableModel);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		studentsWaiting_scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (teacherManageAssignmentsPanelController != null) {
					teacherManageAssignmentsPanelController.updateFields();
				}
			}
		});

		add(studentsWaiting_scrollPane);
	}

	@Override
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
		
		table.setModel(tableModel);

	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	private void ereaseAll() {
		eraseTable();
	}

	public Student getSelectedStudent() {
		try {
			return students.get(table.getSelectedRow());
		} catch (Exception e) {
			return null;
		}

	}

	public void setTeacherManageAssignmentsPanelController(
			ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController) {
		this.teacherManageAssignmentsPanelController = teacherManageAssignmentsPanelController;
	}
	
	

}