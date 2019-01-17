package com.controllers.admin.implementation;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateSpecializationsController;
import com.controllers.admin.IAdminManageSpecializationsController;
import com.controllers.admin.IAdminModifySpecializationController;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.model.repository.SpecializationRepository;
import com.views.admin.AdminPanel;
import com.views.admin.ManageSpecializations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

@Component
public class AdminManageSpecializationsController implements IAdminManageSpecializationsController, Initializable{

	
	
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

	private ObservableList<Specialization> items = FXCollections.observableArrayList();

	public AdminManageSpecializationsController() {
		super();
	}

	public AdminManageSpecializationsController(SpecializationDAO specializationsDAO,
			IAdminModifySpecializationController adminModifySpecializationsController,
			IAdminCreateSpecializationsController adminCreateSpecializationsController) {
		super();
		this.specializationsRepository = specializationsDAO;
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



	public void openCreateSpecializationFrame() {
		adminCreateSpecializationsController.openCreateSpecializationFrame();
	}

	public void openModifySpecializationFrame() {
		Specialization selectedSpecialization = specializationLV.getSelectionModel().getSelectedItem();;
		adminModifySpecializationsController.setSpecialization(selectedSpecialization);
		adminModifySpecializationsController.openModifySpecializationFrame();
	}


	public void viewSpecializations() {
		stateChanged();
		adminPanel.setPanel(adminManageSpecializations);
	}



	private void stateChanged() {
		specializationsList = specializationsRepository.findAll();
		adminManageSpecializations.populate(specializationsList);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		specializationLV.setCellFactory(new Callback<ListView<Specialization>, ListCell<Specialization>>(){
			 
            @Override
            public ListCell<Specialization> call(ListView<Specialization> p) {
                 
                ListCell<Specialization> cell = new ListCell<Specialization>(){
 
                    @Override
                    protected void updateItem(Specialization t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            setText(t.getName());
                        }
                    }
 
                };
                 
                return cell;
            }
        });
		
		specializationLV.setItems(items);
	    List<Specialization> specializations = specializationsRepository.findAll();
		items.addAll(specializations);
	}

	@Override
	public void openModifySpecializationFrame(Specialization specialization) {
		// TODO Auto-generated method stub
		
	}

}
