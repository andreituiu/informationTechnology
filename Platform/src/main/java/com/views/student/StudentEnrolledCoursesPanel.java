package com.views.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.views.common.ILanguagePanel;

@Component
public class StudentEnrolledCoursesPanel extends JPanel implements ILanguagePanel {

	private JTextField textField;

	private JLabel deadlineLabel;
	private JLabel lastUploadLabel;
	private JLabel gradeLabel;
	private JLabel fileNamelabel;

	private JButton btnChooseFileUpload;
	private JButton btnSearch;
	private JButton btnSave;

	private JTextField deadlineTextField;
	private JTextField lastUploadTextField;
	private JTextField gradeTextField;
	private JTextField fileNameTextField;

	private JComboBox<Assignment> assignmentComboBox;
	private DefaultListModel<Course> coursesListModel;
	private JList<Course> coursesList;

	@Autowired
	private IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;

	public StudentEnrolledCoursesPanel() {
		super();
//		initialzie();
	}

	@PostConstruct
	private void initialzie() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 12, 474, 31);
		add(textField);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(510, 9, 209, 35);
		add(btnSearch);

		coursesListModel = new DefaultListModel<Course>();

		assignmentComboBox = new JComboBox<Assignment>();
		assignmentComboBox.setBounds(365, 90, 354, 31);
		add(assignmentComboBox);

		assignmentComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				studentEnrolledCoursesPanelController
						.assignmentSelected((Assignment) assignmentComboBox.getSelectedItem());

			}
		});
		deadlineTextField = new JTextField();
		deadlineTextField.setBounds(365, 133, 354, 31);
		add(deadlineTextField);
		deadlineTextField.setEditable(false);
		deadlineTextField.setColumns(10);

		lastUploadTextField = new JTextField();
		lastUploadTextField.setColumns(10);
		lastUploadTextField.setBounds(365, 175, 354, 31);
		lastUploadTextField.setEditable(false);
		add(lastUploadTextField);

		gradeTextField = new JTextField();
		gradeTextField.setColumns(10);
		gradeTextField.setBounds(365, 218, 354, 31);
		gradeTextField.setEditable(false);
		add(gradeTextField);

		deadlineLabel = new JLabel("Deadline");
		deadlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deadlineLabel.setLocation(207, 132);
		deadlineLabel.setSize(209, 31);
		add(deadlineLabel);

		btnChooseFileUpload = new JButton("Choose file");
		btnChooseFileUpload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChooseFileUpload.setBounds(365, 338, 154, 35);
		add(btnChooseFileUpload);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(565, 338, 154, 35);
		add(btnSave);

		lastUploadLabel = new JLabel("Last upload");
		lastUploadLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastUploadLabel.setBounds(207, 175, 209, 31);
		add(lastUploadLabel);

		gradeLabel = new JLabel("Grade");
		gradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gradeLabel.setBounds(207, 218, 209, 31);
		add(gradeLabel);

		JScrollPane scrollCourses = new JScrollPane();
		//		JPanel coursePanel = new JPanel();
//		coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.PAGE_AXIS));
//		JScrollPane courses = new JScrollPane();
//		coursePanel.setBounds(10, 56, 171, 402);
////		coursePanel.add(courses);
//		add(coursePanel);
		coursesList = new JList<Course>(coursesListModel);
		coursesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollCourses.setBounds(10, 56, 171, 402);
		scrollCourses.setViewportView(coursesList);
		add(scrollCourses);
//		courses.add(coursesList);
		
		coursesList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					studentEnrolledCoursesPanelController.courseSelected((Course) coursesList.getSelectedValue());
				}
			}
		});

		btnChooseFileUpload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				studentEnrolledCoursesPanelController.chooseFileUpload();
			}
		});

//		JPanel boxPanel = new JPanel();
//		courses.setColumnHeaderView(boxPanel);
//		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
//		boxPanel.add(coursesList);

		fileNameTextField = new JTextField();
		fileNameTextField.setEditable(false);
		fileNameTextField.setColumns(10);
		fileNameTextField.setBounds(365, 261, 354, 31);
		add(fileNameTextField);

		fileNamelabel = new JLabel("File name");
		fileNamelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fileNamelabel.setBounds(207, 260, 209, 31);
		add(fileNamelabel);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				studentEnrolledCoursesPanelController.save();
			}
		});
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		deadlineLabel.setText(languageBundle.getString("deadline"));
		btnChooseFileUpload.setText(languageBundle.getString("upload"));
		lastUploadLabel.setText(languageBundle.getString("lastUpload"));
		gradeLabel.setText(languageBundle.getString("grade"));
		btnSearch.setText(languageBundle.getString("search"));

	}

	public void populateCourses(List<Course> courses) {
		ereaseAll();
		if (courses == null || courses.isEmpty()) {
			return;
		}
		for (Course course : courses) {
			coursesListModel.addElement(course);
		}
		coursesList.setSelectedIndex(0);
		studentEnrolledCoursesPanelController.courseSelected(coursesList.getSelectedValue());
	}

	private void ereaseAll() {
		coursesListModel.clear();
		assignmentComboBox.removeAll();
		deadlineTextField.setText("");
		lastUploadTextField.setText("");
		gradeTextField.setText("");
	}

	public void populateAssignments(List<Assignment> courseAssignments) {
		DefaultComboBoxModel<Assignment> model = (DefaultComboBoxModel) assignmentComboBox.getModel();
		model.removeAllElements();
		deadlineTextField.setText("");
		lastUploadTextField.setText("");
		gradeTextField.setText("");
		if (courseAssignments == null || courseAssignments.isEmpty()) {
			return;
		}
		for (Assignment assignment : courseAssignments) {
			assignmentComboBox.addItem(assignment);
		}
		studentEnrolledCoursesPanelController.assignmentSelected((Assignment) assignmentComboBox.getSelectedItem());
	}

	public void setDeadline(Date deadline) {
		if (deadline == null) {
			deadlineTextField.setText("");
		} else {
			deadlineTextField.setText(deadline.toString());
		}
	}

	public void setLastUpload(Date lastUpload) {
		if (lastUpload == null) {
			lastUploadTextField.setText("");
		} else {
			lastUploadTextField.setText(lastUpload.toString());
		}
	}

	public void setGrade(Double grade) {
		if (grade == null) {
			gradeTextField.setText("");
		} else {
			gradeTextField.setText(grade.toString());
		}
	}

	public void setFileName(String fileName) {
		fileNameTextField.setText(fileName);
	}
}