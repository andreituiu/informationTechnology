package com.controllers.admin;

import com.model.User;
import com.views.admin.AdminPanel;
import com.views.admin.ManageUsers;

public interface IAdminManageUsersController {

	void openCreateUserFrame();

	void openModifyUserFrame(Object selectedUser);

	void deleteUser(User selectedUser);

	void userSelected(User user);

	void search();

	void viewUsers();

	void setAdminManageUsers(ManageUsers adminManageUsers);

	void setAdminPanel(AdminPanel adminPanel);

}
