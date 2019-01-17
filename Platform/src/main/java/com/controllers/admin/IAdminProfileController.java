package com.controllers.admin;

import org.springframework.stereotype.Component;

import com.model.Admin;
import com.views.admin.AdminPanel;
import com.views.admin.AdminProfile;

@Component
public interface IAdminProfileController {

	void setAdminPanel(AdminPanel adminPanel);

	void setAdminProfilePanel(AdminProfile adminProfile);

	void viewProfile();

	void setAdmin(Admin admin);
	
	void changePassword();

	void changeSave();
	
}
