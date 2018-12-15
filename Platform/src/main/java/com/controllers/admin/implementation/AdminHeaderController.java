package com.controllers.admin.implementation;

import com.controllers.admin.IAdminHeaderController;
import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.IAdminManageSpecializationsController;
import com.controllers.admin.IAdminManageUsersController;
import com.controllers.admin.IAdminProfileController;
import com.controllers.common.IEmailPanelController;

public class AdminHeaderController implements IAdminHeaderController{
	
	private IAdminProfileController adminProfileController;
	
	private IAdminManageCoursesController adminManageCoursesController;
	
	private IAdminManageSpecializationsController adminManageSpecializationsController;

	private IEmailPanelController emailPanelController;

	private IAdminManageUsersController adminManageUsersController;
	
	
	
	

	public AdminHeaderController(IAdminProfileController adminProfileController,
			IAdminManageCoursesController adminManageCoursesController,
			IAdminManageSpecializationsController adminManageSpecializationsController,
			IAdminManageUsersController adminManageUsersController,
			IEmailPanelController emailPanelController) {
		super();
		this.adminProfileController = adminProfileController;
		this.adminManageCoursesController = adminManageCoursesController;
		this.adminManageSpecializationsController = adminManageSpecializationsController;
		this.emailPanelController = emailPanelController;
		this.adminManageUsersController = adminManageUsersController;
	}

	@Override
	public void viewProfile() {
		adminProfileController.viewProfile();
	}

	@Override
	public void viewCourses() {
		adminManageCoursesController.viewCourses();
		
	}

	@Override
	public void viewSpecializations() {
		adminManageSpecializationsController.viewSpecializations();
		
	}

	@Override
	public void viewEmail() {
		
		emailPanelController.viewEmail();
		
	}

	@Override
	public void viewUsers() {
		adminManageUsersController.viewUsers();
	}

}
