package com.controllers.admin;

import com.model.Specialization;
import com.views.admin.ModifySpecialization;

public interface IAdminModifySpecializationController {

	void saveSpecialization();
	void openModifySpecializationFrame(Specialization specialization);
	void setAdminModifySpecialization(ModifySpecialization adminModifySpecialization);



}
