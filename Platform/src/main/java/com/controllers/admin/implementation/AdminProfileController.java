package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminProfileController;
import com.model.Admin;
import com.model.repository.AdminRepository;
import com.views.admin.AdminPanel;
import com.views.admin.AdminProfile;
import com.views.student.StudentProfileInformationPanel;

@Component
public class AdminProfileController implements IAdminProfileController {

	@Autowired
	private AdminPanel adminPanel;
	
	@Autowired
	private AdminProfile adminProfile;
	
	@Autowired
	private AdminRepository adminRepository;
	
	private Admin admin;

	public AdminProfileController(Admin admin) {
		super();
		this.admin = admin;
	}
	
	public AdminProfileController() {
		super();
	}

	@Override
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public void setAdminPanel(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}

	@Override
	public void setAdminProfilePanel(AdminProfile adminProfile) {
		this.adminProfile = adminProfile;
	}

	@Override
	public void viewProfile() {
		adminProfile.ereaseAll();
		update();
		adminPanel.setPanel(adminProfile);
	}

	private void update() {
		adminProfile.setUsername(admin.getName());
		adminProfile.setSurname(admin.getSurname());
		adminProfile.setCNP(admin.getCnp());
		adminProfile.setExternalEmail(admin.getExternalEmail());
		adminProfile.setInternalEmail(admin.getInternalEmail());
	}
	
	@Override
	public void changePassword() {
		String oldPass = adminProfile.getOldPassword();
		String newPass = adminProfile.getNewPassword();
		String confirmPass = adminProfile.getConfirmPassword();
		
		if(admin.getPassword().equals(oldPass)) {
			if(newPass.equals(confirmPass)) {
				admin.setPassword(newPass);
				adminRepository.save(admin);
			}
		}
	}

	@Override
	public void changeSave() {
		String newEmail = adminProfile.getExternalEmail();
		admin.setExternalEmail(newEmail);
		adminRepository.save(admin);
	}
}
