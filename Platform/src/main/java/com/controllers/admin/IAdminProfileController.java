package com.controllers.admin;

import com.views.admin.AdminPanel;
import com.views.admin.AdminProfile;

public interface IAdminProfileController {

	void setAdminPanel(AdminPanel adminPanel);

	void setAdminProfilePanel(AdminProfile adminProfile);

	void viewProfile();
	
}
