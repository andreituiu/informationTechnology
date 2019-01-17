package com.controllers.admin.implementation;

import java.awt.Window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateSpecializationsController;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.model.repository.SpecializationRepository;
import com.views.admin.CreateSpecialization;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
@Component
public class AdminCreateSpecializationsController implements IAdminCreateSpecializationsController {

	@Autowired
	private CreateSpecialization adminCreateSpecialization;
	
	@Autowired
	private SpecializationRepository specializationRepository;
	
	@FXML
	private TextField specializationNameTF;

	
	private Stage adminCreateSpecializationStage;
	
	public AdminCreateSpecializationsController(SpecializationDAO specializationDAO) {
		super();
		this.specializationRepository = specializationDAO;
	}

	
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
	}
	
	public void openCreateSpecializationFrame() {
		adminCreateSpecialization.ereaseAll();
		adminCreateSpecialization.setVisible(true);
	}

}
