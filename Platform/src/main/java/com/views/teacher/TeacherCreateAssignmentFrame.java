package com.views.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;

@Component
public class TeacherCreateAssignmentFrame extends JFrame {
	private JTextField nameTextField;
	private JTextField deadlineTextField;

	@Autowired
	private ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController;

	public TeacherCreateAssignmentFrame(ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController)
			throws HeadlessException {
		super();
		this.teacherCreateAssignmentFrameController = teacherCreateAssignmentFrameController;

		initialize();
	}

	public TeacherCreateAssignmentFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void initialize() {
		setSize(700, 300);
		setResizable(false);

		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(215, 228, 242));

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(280, 186, 209, 35);
		getContentPane().add(btnSave);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(45, 61, 209, 31);
		getContentPane().add(lblName);

		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeadline.setBounds(45, 128, 209, 31);
		getContentPane().add(lblDeadline);

		nameTextField = new JTextField();
		nameTextField.setBounds(199, 62, 354, 31);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		deadlineTextField = new JTextField();
		deadlineTextField.setBounds(199, 129, 354, 31);
		getContentPane().add(deadlineTextField);
		deadlineTextField.setColumns(10);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teacherCreateAssignmentFrameController.save();
			}
		});
	}

	public String getDeadline() {
		return deadlineTextField.getText();
	}

	public String getName() {
		return nameTextField.getText();
	}

	public void ereaseAll() {
		deadlineTextField.setText("");
		nameTextField.setText("");
	}

	public void showPopup(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
