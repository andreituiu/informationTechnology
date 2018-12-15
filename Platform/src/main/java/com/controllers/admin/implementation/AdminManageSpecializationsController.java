package com.controllers.admin.implementation;

import java.util.List;

import com.controllers.admin.IAdminCreateSpecializationsController;
import com.controllers.admin.IAdminManageSpecializationsController;
import com.controllers.admin.IAdminModifySpecializationController;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.model.dao.SpecializationDAO;
import com.views.admin.AdminPanel;
import com.views.admin.ManageSpecializations;

public class AdminManageSpecializationsController implements IAdminManageSpecializationsController{

	
	private IAdminModifySpecializationController adminModifySpecializationsController;
	
	private IAdminCreateSpecializationsController adminCreateSpecializationsController;
	
	private ManageSpecializations adminManageSpecializations;
	
	private List<Specialization> specializationsList;

	private SpecializationDAO specializationsDAO;

	private AdminPanel adminPanel;
	
	 

	public AdminManageSpecializationsController(SpecializationDAO specializationsDAO,
			IAdminModifySpecializationController adminModifySpecializationsController,
			IAdminCreateSpecializationsController adminCreateSpecializationsController) {
		super();
		this.specializationsDAO = specializationsDAO;
		this.adminModifySpecializationsController = adminModifySpecializationsController;
		this.adminCreateSpecializationsController = adminCreateSpecializationsController;
	}


	
//	@Override
//	public void specializationSelected(Specialization selectedSpecialization) {
//		
//		adminManageSpecializationsController.specializationSelected(selectedSpecialization);
//		
//	}

	
	
	@Override
	public void setAdminManageSpecializations(ManageSpecializations adminManageSpecializations) {
		this.adminManageSpecializations = adminManageSpecializations;
	}


	@Override
	public void setAdminPanel(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}



	@Override
	public void openCreateSpecializationFrame() {
		adminCreateSpecializationsController.openCreateSpecializationFrame();
		
	}


	@Override
	public void openModifySpecializationFrame(Specialization specialization) {
		adminModifySpecializationsController.openModifySpecializationFrame(specialization);
	}


	public void viewSpecializations() {
		stateChanged();
		adminPanel.setPanel(adminManageSpecializations);
	}



	private void stateChanged() {
		specializationsList = specializationsDAO.getAllSpecializations();
		adminManageSpecializations.populate(specializationsList);
		
	}

}
