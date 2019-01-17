package com.controllers.admin;

import com.model.Specialization;
import com.views.admin.AdminPanel;
import com.views.admin.ManageSpecializations;

public interface IAdminManageSpecializationsController {

	void openCreateSpecializationFrame();
	
	void openModifySpecializationFrame(Specialization specialization);

	void viewSpecializations();

	void setAdminManageSpecializations(ManageSpecializations adminManageSpecializations);

	void setAdminPanel(AdminPanel adminPanel);

	

	

}
