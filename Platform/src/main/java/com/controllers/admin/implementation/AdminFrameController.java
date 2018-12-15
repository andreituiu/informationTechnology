package com.controllers.admin.implementation;

import com.controllers.admin.IAdminFrameController;
import com.controllers.admin.IAdminProfileController;
import com.controllers.common.IEmailPanelController;
import com.model.Admin;
import com.model.User;
import com.views.admin.AdminFrame;

public class AdminFrameController implements IAdminFrameController {

	private IAdminProfileController adminProfileController;
	private AdminFrame adminFrame;
	private IEmailPanelController mailPanelController;

	public AdminFrameController(IAdminProfileController adminProfileController, IEmailPanelController mailPanelController) {
		this.adminProfileController = adminProfileController;
		this.mailPanelController = mailPanelController;
	}

	@Override
	public void setAdmin(Admin admin) {
		adminProfileController.setAdmin(admin);
	}

	
	@Override
	public void setAdminFrame(AdminFrame adminFrame) {
		this.adminFrame = adminFrame;
	}

	@Override
	public void openFrame() {
		adminFrame.setVisible(true);
	}

	@Override
	public void setUser(User user) {
		mailPanelController.setUser(user);
	}

}
