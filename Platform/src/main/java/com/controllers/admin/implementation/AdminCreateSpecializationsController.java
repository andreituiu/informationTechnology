package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateSpecializationsController;
import com.controllers.admin.IAdminManageSpecializationsController;
import com.model.Specialization;
import com.model.repository.SpecializationRepository;
import com.views.admin.CreateSpecialization;

@Component
public class AdminCreateSpecializationsController implements IAdminCreateSpecializationsController {

	@Autowired
	private CreateSpecialization adminCreateSpecialization;

	@Autowired
	private SpecializationRepository specializationRepository;

	@Autowired
	private IAdminManageSpecializationsController adminManageSpecializationsController;

	public AdminCreateSpecializationsController() {
		super();
	}

	@Override
	public void setAdminCreateSpecialization(CreateSpecialization adminCreateSpecialization) {
		this.adminCreateSpecialization = adminCreateSpecialization;
	}

	@Override
	public void saveSpecialization() {
		Specialization specialization = new Specialization();

		specialization.setName(adminCreateSpecialization.getSpecializationName());

		specializationRepository.save(specialization);
		adminManageSpecializationsController.viewSpecializations();
	}

	public void openCreateSpecializationFrame() {
		adminCreateSpecialization.ereaseAll();
		adminCreateSpecialization.setVisible(true);
	}

}
