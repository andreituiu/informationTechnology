package com.controllers.admin.implementation;

import com.controllers.admin.IAdminProfileController;
import com.model.Admin;
import com.model.dao.AdminDAO;
import com.views.admin.AdminPanel;
import com.views.admin.AdminProfile;
import com.views.student.StudentProfileInformationPanel;

public class AdminProfileController implements IAdminProfileController {

	private AdminPanel adminPanel;
	private AdminProfile adminProfile;
	private Admin admin;
	private AdminDAO adminDAO;

	public AdminProfileController(Admin admin, AdminDAO adminDAO) {
		super();
		this.admin = admin;
		this.adminDAO = adminDAO;
	}
	
	public AdminProfileController(AdminDAO adminDAO) {
		super();
		this.adminDAO = adminDAO;
	}

	@Override
	public void setAdmin(Admin admin) {
		this.admin = admin;
		update();
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
				adminDAO.update(admin);
			}
		}
	}

	@Override
	public void changeSave() {
		String newEmail = adminProfile.getExternalEmail();
		admin.setExternalEmail(newEmail);
		adminDAO.update(admin);
	}
}
