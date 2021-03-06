package com.views.student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentFindCoursePannelController;
import com.model.Course;
import com.views.common.ILanguagePanel;

@Component
public class StudentFindCoursePannel extends JPanel implements ILanguagePanel {

	private JTextField searchTextField;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPanel;
	private JButton btnSearch;
	private JButton btnEnrole;

	private String[] tableColumns = { "Status", "Course name", "Teacher name", "Specialization" };
	private List<Course> courses;
	private String pending = "Pending";
	private String enrolled = "Enrolled";

	@Autowired
	private IStudentFindCoursePannelController studentFindCoursesController;

	public StudentFindCoursePannel(IStudentFindCoursePannelController studentFindCoursesController) {
		this.studentFindCoursesController = studentFindCoursesController;
		initialize();
	}

	public StudentFindCoursePannel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	private void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		searchTextField = new JTextField();
		searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchTextField.setBounds(24, 11, 490, 31);
		add(searchTextField);
		searchTextField.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(548, 9, 209, 35);
		add(btnSearch);

		btnEnrole = new JButton("Enrole");
		btnEnrole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnrole.setBounds(548, 62, 209, 35);
		add(btnEnrole);

		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);

		tablePanel.setLayout(null);

		tablePanel.setPreferredSize(new Dimension(536, 246));

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "Status", "Course name", "Teacher name", "Specialization" }));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(27, 71, 487, 443);
		add(scrollPanel);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				studentFindCoursesController.searchCourse();
			}
		});

		btnEnrole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				studentFindCoursesController.sendPendingRequest(getSelectedCourse());
			}
		});

	}

	private Course getSelectedCourse() {

		return courses.get(table.getSelectedRow());
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {
		btnEnrole.setText(languageBundle.getString("enrole"));
		btnSearch.setText(languageBundle.getString("search"));

	}

	public void populate(List<Course> notEnrolledCourses, List<Course> pendingCoursesCourses,
			List<Course> enrolledCourses) {
		eraseTable();
		this.courses = new ArrayList<>();
		courses.addAll(notEnrolledCourses);
		courses.addAll(pendingCoursesCourses);
		courses.addAll(enrolledCourses);

		for (Course course : notEnrolledCourses) {
			Object[] newRow = { "", course.getName(),
					course.getTeacher().getName() + " " + course.getTeacher().getSurname(),
					course.getSpecialization() };
			tableModel.addRow(newRow);
		}

		for (Course course : pendingCoursesCourses) {
			Object[] newRow = { pending, course.getName(),
					course.getTeacher().getName() + " " + course.getTeacher().getSurname(),
					course.getSpecialization() };
			tableModel.addRow(newRow);
		}

		for (Course course : enrolledCourses) {
			Object[] newRow = { enrolled, course.getName(),
					course.getTeacher().getName() + " " + course.getTeacher().getSurname(),
					course.getSpecialization() };
			tableModel.addRow(newRow);
		}
		table.setModel(tableModel);
	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	public String getSearchedText() {
		return searchTextField.getText();
	}

}
