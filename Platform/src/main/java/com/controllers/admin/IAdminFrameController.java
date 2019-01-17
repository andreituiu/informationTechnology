package com.controllers.admin;

import com.model.Admin;
import com.views.admin.AdminFrame;

public interface IAdminFrameController {

	void setAdmin(Admin admin);

	void openFrame();

	void setAdminFrame(AdminFrame adminFrame);

}
