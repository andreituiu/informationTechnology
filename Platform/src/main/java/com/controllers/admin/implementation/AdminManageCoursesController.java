package com.controllers.admin.implementation;

import java.util.List;

import com.controllers.admin.IAdminCreateCoursesController;
import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.IAdminModifyCoursesController;
import com.model.Course;
import com.model.dao.CourseDAO;
import com.views.admin.AdminPanel;
import com.views.admin.ManageCourses;

public class AdminManageCoursesController implements IAdminManageCoursesController {

	private IAdminCreateCoursesController adminCreateCourseController;
	private IAdminModifyCoursesController adminModifyCourseController;
	private ManageCourses adminManageCourses;
	private AdminPanel adminPanel;
	private CourseDAO coursesDAO;
	private List<Course> coursesList;

	public AdminManageCoursesController(CourseDAO coursesDAO, IAdminCreateCoursesController adminCreateCourseController,
			IAdminModifyCoursesController adminModifyCourseController) {
		super();
		this.coursesDAO = coursesDAO;
		this.adminCreateCourseController = adminCreateCourseController;
		this.adminModifyCourseController = adminModifyCourseController;
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
		adminModifyCourseController.courseSelected(selectedCourse);
		adminModifyCourseController.openFrame();

	}

	@Override
	public void viewCourses() {
		stateChanged();
		adminPanel.setPanel(adminManageCourses);
	}

	private void stateChanged() {
		coursesList = coursesDAO.getAllCourses();
		adminManageCourses.populate(coursesList);
		
	}

}
