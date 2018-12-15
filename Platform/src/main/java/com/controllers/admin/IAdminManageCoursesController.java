package com.controllers.admin;

import com.model.Course;
import com.views.admin.AdminPanel;
import com.views.admin.ManageCourses;

public interface IAdminManageCoursesController {
	
	void openModifyCourseFrame(Course selectedCourse);
	void openCreateCourseFrame();
	void courseSelected(Course selectedCourse);
	void viewCourses();
	void setAdminManageCourses(ManageCourses adminManageCourses);
	void setAdminPanel(AdminPanel adminPanel);
	
}
