package com.controllers.admin;

import com.model.Admin;
import com.views.admin.AdminPanel;
import com.views.admin.AdminProfile;

public interface IAdminProfileController {

	void setAdminPanel(AdminPanel adminPanel);

	void setAdminProfilePanel(AdminProfile adminProfile);

	void viewProfile();

	void setAdmin(Admin admin);

	void changePassword();

	void changeSave();
	
}
