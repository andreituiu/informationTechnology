package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminFrameController;
import com.controllers.admin.IAdminProfileController;
import com.controllers.common.IEmailPanelController;
import com.model.Admin;
import com.views.admin.AdminFrame;

@Component
public class AdminFrameController implements IAdminFrameController {

	@Autowired
	private IAdminProfileController adminProfileController;

	@Autowired
	private AdminFrame adminFrame;

	@Autowired
	@Qualifier("adminEmailPanelController")
	private IEmailPanelController adminPanelController;

	public AdminFrameController(IAdminProfileController adminProfileController) {
		this.adminProfileController = adminProfileController;
	}

	public AdminFrameController() {
		super();
	}

	@Override
	public void setAdmin(Admin admin) {
		adminProfileController.setAdmin(admin);
		adminPanelController.setUser(admin);
		adminProfileController.viewProfile();
	}

	@Override
	public void setAdminFrame(AdminFrame adminFrame) {
		this.adminFrame = adminFrame;
	}

	@Override
	public void openFrame() {
		adminFrame.setVisible(true);
	}

}
