package com.views.student;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class StudentEnrolledCoursesPanel extends JPanel {

	private JTextField textField;
	private JTextField txtDeadline;
	private JTextField textField_1;
	private JTextField textField_2;

	public StudentEnrolledCoursesPanel() {
		initialzie();
	}

	private void initialzie() {
		setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 12, 317, 20);
		add(textField);

		JButton button = new JButton("Search");
		button.setBounds(360, 11, 80, 23);
		add(button);

		JScrollPane courses = new JScrollPane();
		courses.setLocation(10, 43);
		courses.setSize(151, 243);

		DefaultListModel listModel = new DefaultListModel();
		JList list = new JList(listModel);

		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
		boxPanel.add(list);
		courses.setViewportView(boxPanel);

		add(courses);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 43, 269, 23);
		add(comboBox);

		txtDeadline = new JTextField();
		txtDeadline.setBounds(320, 92, 120, 23);
		add(txtDeadline);
		txtDeadline.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(320, 127, 120, 23);
		add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(320, 166, 120, 23);
		add(textField_2);

		JLabel deadlineLabel = new JLabel("Deadline");
		deadlineLabel.setLocation(192, 92);
		deadlineLabel.setSize(100, 23);
		add(deadlineLabel);

		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(269, 204, 89, 23);
		add(btnUpload);

		JLabel lastUploadLabel = new JLabel("Last upload");
		lastUploadLabel.setBounds(192, 131, 100, 23);
		add(lastUploadLabel);

		JLabel gradeLabel = new JLabel("Grade");
		gradeLabel.setBounds(192, 170, 100, 23);
		add(gradeLabel);
	}
}
