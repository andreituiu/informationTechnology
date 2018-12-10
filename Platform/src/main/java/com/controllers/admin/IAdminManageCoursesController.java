package com.controllers.admin;

import com.model.Course;

public interface IAdminManageCoursesController {
	
	void openModifyCourseFrame();
	void openCreateCourseFrame();
	void courseSelected(Course selectedCourse);
	
}
