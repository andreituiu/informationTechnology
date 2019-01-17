package com.controllers.admin;

import com.model.Specialization;
import com.model.User;
import com.views.admin.ModifyUser;

public interface IAdminModifyUserController {
	void saveUser();

	void openFrame(User selectedUser);

	void setAdminModifyUsers(ModifyUser adminModifyUsers);
//
//	void selectSpecialization(Specialization specialization);
//
//	void saveUser();
//
//	void selectAdmin();
//
//	void selectStudent();
//
//	void selectTeacher();

	void selectSpecialization(Specialization selectedSpecialization);

}
