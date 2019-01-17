package com.controllers.admin.implementation;

import java.awt.Component;

import org.springframework.beans.factory.annotation.Autowired;

import com.controllers.admin.IAdminModifySpecializationController;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.model.repository.SpecializationRepository;
import com.views.admin.ModifySpecialization;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@org.springframework.stereotype.Component
public class AdminModifySpecializationController implements IAdminModifySpecializationController {

	private Specialization specializationSelected;
	private ModifySpecialization adminModifySpecialization;
	private Stage modifySpecializationStage;
	private Specialization specialization;

	@Autowired
	private SpecializationRepository specializationRepository;
	
	@FXML
	private TextField specializationNameTF;

	
	
	public AdminModifySpecializationController() {
		super();
	}


	public AdminModifySpecializationController(SpecializationDAO specializationDAO) {
		super();
		this.specializationRepository = specializationDAO;
	}

	
	@Override
	public void setAdminModifySpecialization(ModifySpecialization adminModifySpecialization) {
		this.adminModifySpecialization = adminModifySpecialization;
	}



	@Override
	public void saveSpecialization() {
		
		specializationSelected.setName(adminModifySpecialization.getName());
		
		specializationRepository.updateSpecializationName(specializationSelected);
	}
	
	@Override
	public void openModifySpecializationFrame(Specialization specialization) {
		specializationSelected = specialization;
		adminModifySpecialization.ereaseAll();
		adminModifySpecialization.setName(specializationSelected.getName());
		adminModifySpecialization.setVisible(true);
		
	}


	@Override
	public void setSpecialization(Specialization selectedSpecialization) {
		specialization = selectedSpecialization;
	}

	public void setModifySpecializationStage(Stage modifySpecializationStage) {
		this.modifySpecializationStage = modifySpecializationStage;
	}


	@Override
	public void openModifySpecializationFrame() {
		updateFrame();
		modifySpecializationStage.show();
	}


	private void updateFrame() {
		specializationNameTF.setText(specialization.getName());
	}
	
	public void modifySpecialization() {
		specialization.setName(specializationNameTF.getText());
		specializationRepository.save(specialization);
	}
}
