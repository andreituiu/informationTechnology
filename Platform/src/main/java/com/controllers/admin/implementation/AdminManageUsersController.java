package com.controllers.admin.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateUserController;
import com.controllers.admin.IAdminManageUsersController;
import com.controllers.admin.IAdminModifyUserController;
import com.model.User;
import com.model.repository.UserRepository;
import com.views.admin.AdminPanel;
import com.views.admin.ManageUsers;

@Component
public class AdminManageUsersController  implements IAdminManageUsersController{

	@Autowired
	private IAdminCreateUserController adminCreateUserController;

	@Autowired
	private UserRepository usersRepository;


	@Autowired
	private ManageUsers adminManageUsers;
	
	List<User> usersList;

	@Autowired
	private AdminPanel adminPanel;

	@Autowired
	private IAdminModifyUserController adminModifyUserController;	
	
	
	public AdminManageUsersController() {
		super();
	}



	@Override
	public void setAdminManageUsers(ManageUsers adminManageUsers) {
		this.adminManageUsers = adminManageUsers;
	}


	@Override
	public void setAdminPanel(AdminPanel adminPanel) {
		this.adminPanel = adminPanel;
	}



	@Override
	public void openCreateUserFrame() {
		adminCreateUserController.openFrame();
		
	}

	@Override
	public void openModifyUserFrame(User selectedUser) {
		adminModifyUserController.openFrame(selectedUser);		
	}

	@Override
	public void deleteUser(User selectedUser) {
		usersRepository.delete(selectedUser);
	}
	
	public void viewUsers() {
		stateChanged();
		adminPanel.setPanel(adminManageUsers);
	}

	private void stateChanged() {
		usersList = usersRepository.findAll();
		adminManageUsers.populate(usersList);
		
	}

	@Override
	public void search() {
		String searchString = adminManageUsers.getSearchString();
		List<User> list = usersRepository.findByCnpContainingOrRoleContainingOrNameContainingOrSurnameContaining(searchString, searchString, searchString, searchString);
		adminManageUsers.populate(list);
	}

}
