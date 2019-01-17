package com.views.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.implementation.AdminCreateCoursesController;
import com.model.Course;
import com.model.Student;
import com.views.common.ILanguagePanel;
import java.awt.Font;

@Component
public class ManageCourses extends JPanel implements ILanguagePanel{

	private JTable table;

	private DefaultTableModel tableModel;

	private JScrollPane scrollPanel;

	private JButton btnModify;
	private JButton btnCreate;

	private String[] tableColumns = { "Name", "Teacher", "Year", "Semester", "Specialization" };

	
	@Autowired
	private IAdminManageCoursesController adminManageCoursesController;

	private List<Course> coursesList;

	public ManageCourses(IAdminManageCoursesController adminManageCoursesController) {
		this.adminManageCoursesController = adminManageCoursesController;
		initialize();
	}

	
	
	public ManageCourses() {
		super();
	}

	@PostConstruct
	public void initialize() {
		setBackground(new Color(215, 228, 242));
		setLayout(null);

		JPanel tablePanel = new JPanel();
		tablePanel.setSize(100, 100);

		tablePanel.setLayout(null);

		tablePanel.setPreferredSize(new Dimension(536, 246));

		tableModel = new DefaultTableModel(tableColumns, 0);

		table = new JTable(tableModel);
		table.setBounds(0, 0, 450, 300);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPanel = new JScrollPane(table);
		scrollPanel.setBounds(23, 29, 526, 410);
		add(scrollPanel);

		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModify.setBounds(188, 460, 209, 35);
		add(btnModify);

		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setBounds(573, 31, 209, 35);
		add(btnCreate);

		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageCoursesController.openCreateCourseFrame();
			}
		});

		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminManageCoursesController.openModifyCourseFrame(getSelectedCourse());
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adminManageCoursesController != null) {
					adminManageCoursesController.courseSelected(getSelectedCourse());
				}
			}
		});
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		btnModify.setText(languageBundle.getString("modify"));
		btnCreate.setText(languageBundle.getString("create"));

	}

	public void populate(List<Course> coursesList) {
        this.coursesList = coursesList;
		ereaseAll();
		if (coursesList == null || coursesList.isEmpty()) {
			return;
		}
		for (Course course : coursesList) {
			Object[] newRow = { course.getName(), course.getTeacher().getName(), course.getYear(), course.getSemester(),
					course.getSpecialization() };
			tableModel.addRow(newRow);
		}
		
		adminManageCoursesController.courseSelected(coursesList.get(0));

	}

	private void eraseTable() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	private void ereaseAll() {
		eraseTable();
	}

	public Course getSelectedCourse() {
		return coursesList.get(table.getSelectedRow());
	}
}
