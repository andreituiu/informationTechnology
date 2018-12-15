package com.controllers.admin.implementation;

import com.controllers.admin.IAdminModifySpecializationController;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.views.admin.ModifySpecialization;

public class AdminModifySpecializationController implements IAdminModifySpecializationController {

	private Specialization specializationSelected;
	private ModifySpecialization adminModifySpecialization;
	private SpecializationDAO specializationDAO;

	
	
	public AdminModifySpecializationController(SpecializationDAO specializationDAO) {
		super();
		this.specializationDAO = specializationDAO;
	}

	
	@Override
	public void setAdminModifySpecialization(ModifySpecialization adminModifySpecialization) {
		this.adminModifySpecialization = adminModifySpecialization;
	}



	@Override
	public void saveSpecialization() {
		String oldName = specializationSelected.getName();
		specializationSelected.setName(adminModifySpecialization.getName());
		
		specializationDAO.updateSpecializationName(specializationSelected, oldName);
	}
	
	@Override
	public void openModifySpecializationFrame(Specialization specialization) {
		specializationSelected = specialization;
		adminModifySpecialization.ereaseAll();
		adminModifySpecialization.setName(specializationSelected.getName());
		adminModifySpecialization.setVisible(true);
		
	}
}
