package com.views.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminModifyCoursesController;
import com.model.Specialization;
import com.model.Teacher;
import com.views.common.ILanguagePanel;

@Component
public class ModifyCourses extends JFrame implements ILanguagePanel {

	private JTextField courseNameTextField;
	private JTextField yearTextField;
	private JTextField semesterTextField;

	private JLabel lblCourseName;
	private JLabel lblYear;
	private JLabel lblSemester;
	private JLabel lblTeacher;
	private JLabel lblSpecialization;

	private JComboBox<Teacher> teacherComboBox;
	private JComboBox<Specialization> specializationComboBox;

	private JButton btnSave;

	@Autowired
	private IAdminModifyCoursesController adminModifyCoursesController;

	public ModifyCourses(IAdminModifyCoursesController adminModifyCoursesController) {
		this.adminModifyCoursesController = adminModifyCoursesController;
		intialize();
	}

	public ModifyCourses() throws HeadlessException {
		super();
	}

	@PostConstruct
	public void intialize() {
		setBackground(new Color(215, 228, 242));
		setSize(800, 500);
		setResizable(false);

		setLayout(null);

		courseNameTextField = new JTextField();
		courseNameTextField.setBounds(245, 31, 354, 31);
		add(courseNameTextField);
		courseNameTextField.setColumns(10);

		yearTextField = new JTextField();
		yearTextField.setBounds(245, 129, 354, 31);
		add(yearTextField);
		yearTextField.setColumns(10);

		semesterTextField = new JTextField();
		semesterTextField.setBounds(245, 82, 354, 31);
		add(semesterTextField);
		semesterTextField.setColumns(10);

		lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourseName.setBounds(41, 30, 209, 31);
		add(lblCourseName);

		lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYear.setBounds(41, 128, 209, 31);
		add(lblYear);

		lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSemester.setBounds(41, 81, 209, 31);
		add(lblSemester);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.setBounds(314, 336, 209, 35);
		add(btnSave);

		lblTeacher = new JLabel("Teacher");
		lblTeacher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeacher.setBounds(41, 191, 209, 31);
		add(lblTeacher);

		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSpecialization.setBounds(41, 272, 209, 31);
		add(lblSpecialization);

		teacherComboBox = new JComboBox();
		teacherComboBox.setForeground(Color.DARK_GRAY);
		teacherComboBox.setBounds(245, 192, 354, 31);
		add(teacherComboBox);

		specializationComboBox = new JComboBox();
		specializationComboBox.setBounds(245, 273, 354, 31);
		add(specializationComboBox);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminModifyCoursesController.saveCourse();
			}
		});

		specializationComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminModifyCoursesController
						.selectSpecialization((Specialization) specializationComboBox.getSelectedItem());
			};
		});

		teacherComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adminModifyCoursesController.selectTeacher((Teacher) teacherComboBox.getSelectedItem());
			}
		});
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {

		lblCourseName.setText(languageBundle.getString("courseName"));
		lblYear.setText(languageBundle.getString("year"));
		lblSemester.setText(languageBundle.getString("semester"));
		lblTeacher.setText(languageBundle.getString("teacher"));
		lblSpecialization.setText(languageBundle.getString("specialization"));
		btnSave.setText(languageBundle.getString("save"));

	}

	public void setName(String name) {
		courseNameTextField.setText(name);
	}

	public void setYear(Integer year) {
		yearTextField.setText("" + year);
	}

	public void setSemester(Integer semester) {
		semesterTextField.setText("" + semester);
	}

	public String getName() {
		return courseNameTextField.getText();
	}

	public String getCourseName() {
		return courseNameTextField.getText();
	}

	public Integer getYear() {
		return new Integer(yearTextField.getText());
	}

	public Integer getSemester() {
		return new Integer(semesterTextField.getText());
	}

	public void ereaseAll() {
		teacherComboBox.removeAll();
		specializationComboBox.removeAll();
		courseNameTextField.setText("");
		yearTextField.setText("");
		semesterTextField.setText("");

	}

	public void populateTeachers(List<Teacher> teachers) {
		DefaultComboBoxModel<Teacher> model = (DefaultComboBoxModel) teacherComboBox.getModel();
		model.removeAllElements();
		if (teachers == null || teachers.isEmpty()) {
			return;
		}

		for (Teacher teacher : teachers) {

			teacherComboBox.addItem(teacher);
		}

		adminModifyCoursesController.selectTeacher((Teacher) teacherComboBox.getSelectedItem());

	}

	public void populateSpecializations(List<Specialization> specializations) {
		DefaultComboBoxModel<Specialization> model = (DefaultComboBoxModel) specializationComboBox.getModel();
		model.removeAllElements();
		if (specializations == null || specializations.isEmpty()) {
			return;
		}

		for (Specialization specialization : specializations) {

			specializationComboBox.addItem(specialization);
		}
		adminModifyCoursesController.selectSpecialization((Specialization) specializationComboBox.getSelectedItem());
	}

	public void setTeacher(Teacher teacher) {

		for (int i = 0; i < teacherComboBox.getModel().getSize(); i++) {

			if (teacherComboBox.getModel().getElementAt(i).equals(teacher)) {
				teacherComboBox.getModel().setSelectedItem(teacher);
				break;
			}
		}

	}

	public void setSpecialization(Specialization specialization) {

		for (int i = 0; i < specializationComboBox.getModel().getSize(); i++) {

			if (specializationComboBox.getModel().getElementAt(i).equals(specialization)) {
				specializationComboBox.getModel().setSelectedItem(specialization);
				break;
			}
		}

	}
}
