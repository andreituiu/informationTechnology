package com.controllers.admin.implementation;

import com.controllers.admin.IAdminManageCoursesController;

public class AdminManageCoursesController implements IAdminManageCoursesController{

	private AdminCreateCoursesController adminCreateCourseController;

	@Override
	public void openCreateCourseFrame() {
		adminCreateCourseController.openFrame();
		
	}
	
	@Override
	public void openModifyCourseFrame() {
		//adminCreateCourseFrame.setVisible(true);
		
	}

}
