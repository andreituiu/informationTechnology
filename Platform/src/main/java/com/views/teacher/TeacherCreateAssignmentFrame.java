package com.views.teacher;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;

public class TeacherCreateAssignmentFrame extends JFrame {
	private JTextField nameTextField;
	private JTextField deadlineTextField;
	private ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController;

	
	
	public TeacherCreateAssignmentFrame(ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController)
			throws HeadlessException {
		super();
		this.teacherCreateAssignmentFrameController = teacherCreateAssignmentFrameController;
		
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(67, 177, 89, 23);
		getContentPane().add(btnSave);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(45, 61, 46, 14);
		getContentPane().add(lblName);

		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(45, 129, 46, 14);
		getContentPane().add(lblDeadline);

		nameTextField = new JTextField();
		nameTextField.setBounds(124, 58, 116, 20);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		deadlineTextField = new JTextField();
		deadlineTextField.setBounds(124, 126, 116, 20);
		getContentPane().add(deadlineTextField);
		deadlineTextField.setColumns(10);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teacherCreateAssignmentFrameController.save();
			}
		});
	}

	public Date getDeadline() {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(deadlineTextField.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getName() {
		return nameTextField.getText();
	}
}
