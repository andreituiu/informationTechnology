package com.controllers.admin;

import com.model.Admin;
import com.model.User;
import com.views.admin.AdminFrame;

public interface IAdminFrameController {

	void setAdmin(Admin admin);

	void openFrame();

	void setAdminFrame(AdminFrame adminFrame);

	void setUser(User user);

}
