package com.controllers.admin.implementation;

import com.controllers.admin.IAdminCreateSpecializationsController;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.views.admin.CreateSpecialization;

public class AdminCreateSpecializationsController implements IAdminCreateSpecializationsController {

	private CreateSpecialization adminCreateSpecialization;
	private SpecializationDAO specializationDAO;
	
	
	
	public AdminCreateSpecializationsController(SpecializationDAO specializationDAO) {
		super();
		this.specializationDAO = specializationDAO;
	}

	
	@Override
	public void setAdminCreateSpecialization(CreateSpecialization adminCreateSpecialization) {
		this.adminCreateSpecialization = adminCreateSpecialization;
	}



	@Override
	public void saveSpecialization() {
		
		Specialization specialization = new Specialization();
		
		specialization.setName(adminCreateSpecialization.getSpecializationName());
		
		specializationDAO.saveNewSpecialization(specialization);
	}
	
	public void openCreateSpecializationFrame() {
		adminCreateSpecialization.ereaseAll();
		adminCreateSpecialization.setVisible(true);
	}

}
