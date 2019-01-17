package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminHeaderController;
import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.IAdminManageSpecializationsController;
import com.controllers.admin.IAdminManageUsersController;
import com.controllers.admin.IAdminProfileController;
import com.controllers.common.IEmailPanelController;


@Component
public class AdminHeaderController implements IAdminHeaderController{
	
	@Autowired
	private IAdminProfileController adminProfileController;
	
	@Autowired
	private IAdminManageCoursesController adminManageCoursesController;
	
	@Autowired
	private IAdminManageSpecializationsController adminManageSpecializationsController;

	@Autowired
	@Qualifier("adminEmailPanelController")
	private IEmailPanelController emailPanelController;

	@Autowired
	private IAdminManageUsersController adminManageUsersController;
	
	
	
	
//
//	public AdminHeaderController(IAdminProfileController adminProfileController,
//			IAdminManageCoursesController adminManageCoursesController,
//			IAdminManageSpecializationsController adminManageSpecializationsController,
//			IAdminManageUsersController adminManageUsersController,
//			IEmailPanelController emailPanelController) {
//		super();
//		this.adminProfileController = adminProfileController;
//		this.adminManageCoursesController = adminManageCoursesController;
//		this.adminManageSpecializationsController = adminManageSpecializationsController;
//		this.emailPanelController = emailPanelController;
//		this.adminManageUsersController = adminManageUsersController;
//	}

	
	
	public AdminHeaderController() {
		super();
		// TODO Auto-generated constructor stub
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
