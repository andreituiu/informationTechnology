package com.controllers.admin.implementation;

import com.controllers.admin.IAdminHeaderController;

public class AdminHeaderController implements IAdminHeaderController{
	
	private AdminProfileController adminProfileController;
	@Override
	public void viewProfile() {
		adminProfileController.viewProfile();
	}

	@Override
	public void viewCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewSpecializations() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewEmail() {
		// TODO Auto-generated method stub
		
	}

}
