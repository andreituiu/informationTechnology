package com.controllers.admin.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminManageSpecializationsController;
import com.model.Specialization;
import com.model.repository.SpecializationRepository;
import com.views.admin.AdminPanel;
import com.views.admin.ManageSpecializations;

@Component
public class AdminManageSpecializationsController implements IAdminManageSpecializationsController {

	@Autowired
	private AdminCreateSpecializationsController adminCreateSpecializationsController;

	@Autowired
	private AdminModifySpecializationController adminModifySpecializationsController;

	@Autowired
	private ManageSpecializations adminManageSpecializations;

	private List<Specialization> specializationsList;

	@Autowired
	private SpecializationRepository specializationsRepository;

	@Autowired
	private AdminPanel adminPanel;

	public AdminManageSpecializationsController() {
		super();
	}

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
	public void openModifySpecializationFrame(Specialization selectedSpecialization) {
		adminModifySpecializationsController.openModifySpecializationFrame(selectedSpecialization);
	}

	public void viewSpecializations() {
		stateChanged();
		adminPanel.setPanel(adminManageSpecializations);
	}

	private void stateChanged() {
		specializationsList = specializationsRepository.findAll();
		adminManageSpecializations.populate(specializationsList);

	}

}
