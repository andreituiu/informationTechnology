package com.controllers.admin;

import com.model.Specialization;
import com.views.admin.CreateUser;

public interface IAdminCreateUserController {

	void selectAdmin();

	void selectStudent();

	void selectTeacher();

	void saveUser();

	void selectSpecialization(Specialization specialization);
	
	void openFrame();

	void setAdminCreateUsers(CreateUser adminCreateUsers);

}
