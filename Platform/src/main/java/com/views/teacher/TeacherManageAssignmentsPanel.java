package com.views.teacher;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.model.Assignment;
import com.model.Student;
import com.model.StudentAssignment;

public class TeacherManageAssignmentsPanel extends JPanel {
	private JComboBox<Assignment> assignmentComboBox;
	private JTextField deadlineTextField;
	private JTextField lastUploadTextField;
	private JTextField gradeTextField;
	private Component deadlineLabel;
	private JButton btnUpload;
	private Component lastUploadLabel;
	private JLabel gradeLabel;
	private JButton btnCreateAssignment;
	private TeacherStudentsTablePanel studentsTablePanel;
	protected ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController;
	private JButton btnSave;
	private JButton btnDeleteStudent;

	public TeacherManageAssignmentsPanel(
			ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController,
			TeacherStudentsTablePanel studentsTablePanel) {
		super();
		this.teacherManageAssignmentsPanelController = teacherManageAssignmentsPanelController;
		this.studentsTablePanel = studentsTablePanel;

		initialize();
	}

	private void initialize() {
		setLayout(null);

//		studentsTablePanel = new TeacherStudentsTablePanel();
		
		studentsTablePanel.setLocation(10, 43);
		studentsTablePanel.setSize(217, 188);
		add(studentsTablePanel);

		assignmentComboBox = new JComboBox<Assignment>();
		assignmentComboBox.setBounds(237, 43, 203, 23);
		add(assignmentComboBox);

		assignmentComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				teacherManageAssignmentsPanelController
						.assignmentSelected((Assignment) assignmentComboBox.getSelectedItem());

			}
		});
		deadlineTextField = new JTextField();
		deadlineTextField.setBounds(320, 92, 120, 23);
		add(deadlineTextField);
		deadlineTextField.setColumns(10);

		lastUploadTextField = new JTextField();
		lastUploadTextField.setColumns(10);
		lastUploadTextField.setBounds(320, 126, 120, 23);
		add(lastUploadTextField);

		gradeTextField = new JTextField();
		gradeTextField.setColumns(10);
		gradeTextField.setBounds(320, 166, 120, 23);
		add(gradeTextField);

		deadlineLabel = new JLabel("Deadline");
		deadlineLabel.setLocation(237, 92);
		deadlineLabel.setSize(61, 23);
		add(deadlineLabel);

		btnUpload = new JButton("Upload");
		btnUpload.setBounds(247, 200, 89, 23);
		add(btnUpload);

		lastUploadLabel = new JLabel("Last upload");
		lastUploadLabel.setBounds(237, 126, 71, 23);
		add(lastUploadLabel);

		gradeLabel = new JLabel("Grade");
		gradeLabel.setBounds(237, 166, 71, 23);
		add(gradeLabel);

		btnCreateAssignment = new JButton("Create assignment");
		btnCreateAssignment.setBounds(260, 9, 159, 23);
		add(btnCreateAssignment);

		btnSave = new JButton("Save");
		btnSave.setBounds(351, 200, 89, 23);
		add(btnSave);
		
		btnDeleteStudent = new JButton("Delete student");
		btnDeleteStudent.setBounds(246, 243, 120, 23);
		add(btnDeleteStudent);

		btnCreateAssignment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teacherManageAssignmentsPanelController.createAssignment();
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teacherManageAssignmentsPanelController.saveGrade();
			}
		});
		
		btnDeleteStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherManageAssignmentsPanelController.deleteStdent(studentsTablePanel.getSelectedStudent());
			}
		});
	}

	public void setAssignments(List<Assignment> assignments) {
		DefaultComboBoxModel<Assignment> model = (DefaultComboBoxModel) assignmentComboBox.getModel();
		model.removeAllElements();
		deadlineTextField.setText("");
		lastUploadTextField.setText("");
		gradeTextField.setText("");

		if (assignments == null || assignments.isEmpty()) {
			return;
		}
		for (Assignment assignment : assignments) {
			assignmentComboBox.addItem(assignment);
		}
		teacherManageAssignmentsPanelController.assignmentSelected((Assignment) assignmentComboBox.getSelectedItem());
	}

	public void setStudents(List<Student> students) {
		studentsTablePanel.populate(students);
	}

	public void setDeadline(Date deadline) {
		if (deadline == null) {
			deadlineTextField.setText("");
		} else {
			deadlineTextField.setText(deadline.toString());
		}
	}

	public void setLastUpdate(Date lastUpdate) {
		if (lastUpdate == null) {
			lastUploadTextField.setText("");
		} else {
			lastUploadTextField.setText(lastUpdate.toString());
		}
	}

	public void setGrade(Double grade) {
		if (grade == null) {
			gradeTextField.setText("");
		} else {
			gradeTextField.setText(grade.toString());
		}
	}

	public Double getGrade() {
		return new Double(gradeTextField.getText());
	}

}
