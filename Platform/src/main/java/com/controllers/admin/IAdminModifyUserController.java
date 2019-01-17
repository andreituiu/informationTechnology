package com.controllers.admin;

import com.model.Specialization;

public interface IAdminModifyUserController {

	void selectSpecialization(Specialization specialization);

	void saveUser();

	void selectAdmin();

	void selectStudent();

	void selectTeacher();

}
