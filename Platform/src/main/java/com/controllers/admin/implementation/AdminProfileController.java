package com.controllers.admin.implementation;

import com.controllers.admin.IAdminProfileController;
import com.model.Admin;
import com.views.admin.AdminPanel;
import com.views.admin.AdminProfile;
import com.views.student.StudentProfileInformationPanel;

public class AdminProfileController implements IAdminProfileController {
	
	private AdminPanel adminPanel;
	private AdminProfile adminProfile;
	private Admin admin;

	public AdminProfileController(Admin admin) {
		super();
		this.admin = admin;
	}


	@Override
	public void setAdminPanel(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}


	@Override
	public void setAdminProfilePanel(AdminProfile adminProfile) {
		this.adminProfile = adminProfile;
	}



	@Override
	public void viewProfile() {
		adminProfile.ereaseAll();
		update();
		adminPanel.setPanel(adminProfile);
	}


	private void update() {
		adminProfile.setUsername(admin.getName());
		adminProfile.setSurname(admin.getSurname());
		adminProfile.setCNP(admin.getCNP());
		adminProfile.setExternalEmail(admin.getExternalEmail());
		adminProfile.setInternalEmail(admin.getInternalEmail());
	}
}
