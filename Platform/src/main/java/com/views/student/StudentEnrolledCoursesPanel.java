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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.views.common.ILanguagePanel;
@Component
public class StudentEnrolledCoursesPanel extends JPanel implements ILanguagePanel{

	private JTextField textField;

	private JTextField txtDeadline;
	private JTextField textField_1;
	private JTextField textField_2;

	private JLabel deadlineLabel;
	private JLabel lastUploadLabel;
	private JLabel gradeLabel;

	private JButton btnUpload;
	private JButton btnSearch;

	private JTextField deadlineTextField;
	private JTextField lastUploadTextField;
	private JTextField gradeTextField;
	private JComboBox<Assignment> assignmentComboBox;
	private DefaultListModel<Course> coursesListModel;
	private JList<Course> coursesList;
	
	@Autowired
	private IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController;

	public StudentEnrolledCoursesPanel(IStudentEnrolledCoursesPanelController studentEnrolledCoursesPanelController) {
		super();
		this.studentEnrolledCoursesPanelController = studentEnrolledCoursesPanelController;

		initialzie();
	}

	
	
	public StudentEnrolledCoursesPanel() {
		super();
		// TODO Auto-generated constructor stub
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
		assignmentComboBox.setBackground(new Color(0, 0, 255));
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
		deadlineTextField.setBounds(365, 147, 354, 31);
		add(deadlineTextField);
		deadlineTextField.setEditable(false);
		deadlineTextField.setColumns(10);

		lastUploadTextField = new JTextField();
		lastUploadTextField.setColumns(10);
		lastUploadTextField.setBounds(365, 213, 354, 31);
		lastUploadTextField.setEditable(false);
		add(lastUploadTextField);

		gradeTextField = new JTextField();
		gradeTextField.setColumns(10);
		gradeTextField.setBounds(365, 270, 354, 31);
		gradeTextField.setEditable(false);
		add(gradeTextField);

		deadlineLabel = new JLabel("Deadline");
		deadlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deadlineLabel.setLocation(207, 146);
		deadlineLabel.setSize(209, 31);
		add(deadlineLabel);

		btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpload.setBounds(459, 337, 209, 35);
		add(btnUpload);

		lastUploadLabel = new JLabel("Last upload");
		lastUploadLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastUploadLabel.setBounds(207, 212, 209, 31);
		add(lastUploadLabel);

		gradeLabel = new JLabel("Grade");
		gradeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gradeLabel.setBounds(207, 269, 209, 31);
		add(gradeLabel);

		JScrollPane courses = new JScrollPane();
		courses.setBounds(10, 56, 170, 423);
		add(courses);
		coursesList = new JList<Course>(coursesListModel);

		coursesList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) {
					studentEnrolledCoursesPanelController.courseSelected((Course) coursesList.getSelectedValue());
				}
			}
		});
		
		btnUpload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				studentEnrolledCoursesPanelController.upload();
			}
		});

		JPanel boxPanel = new JPanel();
		courses.setColumnHeaderView(boxPanel);
		boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));
		boxPanel.add(coursesList);
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		deadlineLabel.setText(languageBundle.getString("deadline"));
		btnUpload.setText(languageBundle.getString("upload"));
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

}