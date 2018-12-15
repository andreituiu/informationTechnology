package com.views.teacher;

import java.awt.Color;
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
import java.awt.Font;

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
		setBackground(new Color(215, 228, 242));

//		studentsTablePanel = new TeacherStudentsTablePanel();

		studentsTablePanel.setLocation(0, 0);
		studentsTablePanel.setSize(541, 183);
		add(studentsTablePanel);

		assignmentComboBox = new JComboBox<Assignment>();
		assignmentComboBox.setBounds(153, 205, 354, 31);
		add(assignmentComboBox);

		assignmentComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				teacherManageAssignmentsPanelController
						.updateFields();

			}
		});
		deadlineTextField = new JTextField();
		deadlineTextField.setBounds(153, 249, 354, 31);
		deadlineTextField.setEditable(false);
		add(deadlineTextField);
		deadlineTextField.setColumns(10);

		lastUploadTextField = new JTextField();
		lastUploadTextField.setColumns(10);
		lastUploadTextField.setBounds(153, 293, 354, 31);
		lastUploadTextField.setEditable(false);
		add(lastUploadTextField);

		gradeTextField = new JTextField();
		gradeTextField.setColumns(10);
		gradeTextField.setBounds(153, 337, 354, 31);
		add(gradeTextField);

		deadlineLabel = new JLabel("Deadline");
		deadlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deadlineLabel.setLocation(44, 249);
		deadlineLabel.setSize(209, 31);
		add(deadlineLabel);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpload.setBounds(533, 290, 170, 35);
		add(btnUpload);

		lastUploadLabel = new JLabel("Last upload");
		lastUploadLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastUploadLabel.setBounds(44, 293, 209, 31);
		add(lastUploadLabel);

		gradeLabel = new JLabel("Grade");
		gradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gradeLabel.setBounds(44, 337, 209, 31);
		add(gradeLabel);

		btnCreateAssignment = new JButton("Create assignment");
		btnCreateAssignment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateAssignment.setBounds(533, 204, 170, 35);
		add(btnCreateAssignment);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(237, 381, 209, 35);
		add(btnSave);

		btnDeleteStudent = new JButton("Delete student");
		btnDeleteStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDeleteStudent.setBounds(553, 13, 150, 35);
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

	public Assignment getSelectedAssignment() {
		return (Assignment) assignmentComboBox.getSelectedItem();
	}

	public Student getSelectedStudent() {
		return studentsTablePanel.getSelectedStudent();
	}

}
