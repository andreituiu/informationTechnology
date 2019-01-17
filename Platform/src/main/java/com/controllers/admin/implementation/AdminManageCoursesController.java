package com.controllers.admin.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.IAdminModifyCoursesController;
import com.model.Course;
import com.model.repository.CourseRepository;
import com.views.admin.AdminPanel;
import com.views.admin.ManageCourses;

import javafx.fxml.FXML;

@Component
public class AdminManageCoursesController implements IAdminManageCoursesController {

	@Autowired
	private AdminCreateCoursesController adminCreateCourseController;

	@Autowired
	private IAdminModifyCoursesController adminModifyCourseController;

	@Autowired
	private ManageCourses adminManageCourses;

	@Autowired
	private AdminPanel adminPanel;
	private List<Course> coursesList;

	@Autowired
	private CourseRepository coursesRepository;

	public AdminManageCoursesController() {
		super();
	}

	@Override
	public void setAdminPanel(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}

	@Override
	public void setAdminManageCourses(ManageCourses adminManageCourses) {
		this.adminManageCourses = adminManageCourses;
	}

	@Override
	public void openCreateCourseFrame() {
		adminCreateCourseController.openFrame();

	}

	@Override
	public void courseSelected(Course selectedCourse) {
		adminModifyCourseController.courseSelected(selectedCourse);

	}

	@Override
	public void openModifyCourseFrame(Course selectedCourse) {
		adminModifyCourseController.openFrame();

	}

	@Override
	public void viewCourses() {
		stateChanged();
		adminPanel.setPanel(adminManageCourses);
	}

	private void stateChanged() {
		coursesList = coursesRepository.findAll();
		adminManageCourses.populate(coursesList);

	}

	@FXML
	public void searchCourse() {
	}

	@FXML
	public void modifyCourse() {
	}

	public void createCourse() {
		adminCreateCourseController.openFrame();
	}

}
