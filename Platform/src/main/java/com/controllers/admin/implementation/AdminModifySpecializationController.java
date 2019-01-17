package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.controllers.admin.IAdminManageSpecializationsController;
import com.controllers.admin.IAdminModifySpecializationController;
import com.model.Specialization;
import com.model.repository.SpecializationRepository;
import com.views.admin.ModifySpecialization;

@org.springframework.stereotype.Component
public class AdminModifySpecializationController implements IAdminModifySpecializationController {

	private Specialization specializationSelected;

	@Autowired
	private ModifySpecialization adminModifySpecialization;

	@Autowired
	private SpecializationRepository specializationRepository;

	@Autowired
	private IAdminManageSpecializationsController adminManageSpecializationsController;

	public AdminModifySpecializationController() {
		super();
	}

	@Override
	public void saveSpecialization() {
		specializationSelected.setName(adminModifySpecialization.getName());
		specializationRepository.save(specializationSelected);
		adminManageSpecializationsController.viewSpecializations();
	}

	@Override
	public void openModifySpecializationFrame(Specialization specialization) {
		specializationSelected = specialization;
		adminModifySpecialization.ereaseAll();
		adminModifySpecialization.setName(specializationSelected.getName());
		adminModifySpecialization.setVisible(true);

	}
}
