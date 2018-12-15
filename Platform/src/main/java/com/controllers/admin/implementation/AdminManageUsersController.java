package com.controllers.admin.implementation;

import java.util.List;

import com.controllers.admin.IAdminCreateUserController;
import com.controllers.admin.IAdminManageUsersController;
import com.controllers.admin.IAdminModifyUserController;
import com.controllers.common.implementation.ROLE;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.dao.UserDAO;
import com.views.admin.AdminPanel;
import com.views.admin.ManageUsers;

public class AdminManageUsersController  implements IAdminManageUsersController{

	private IAdminCreateUserController adminCreateUserController;
	
	private UserDAO usersDAO;
	
	private AdminDAO adminDAO;
	
	private TeacherDAO teacherDAO;
	
	private StudentDAO studentDAO;

	private ManageUsers adminManageUsers;
	
	List<User> usersList;

	private User selectedUser;

	private AdminPanel adminPanel;

	private IAdminModifyUserController adminModifyUserController;
	
	

	public AdminManageUsersController(UserDAO usersDAO, AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO,
			IAdminCreateUserController adminCreateUserController, IAdminModifyUserController adminModifyUserController) {
		super();
		this.usersDAO = usersDAO;
		this.adminDAO = adminDAO;
		this.teacherDAO = teacherDAO;
		this.studentDAO = studentDAO;
		this.adminCreateUserController = adminCreateUserController;
		this.adminModifyUserController = adminModifyUserController;
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
	
		usersDAO.deleteUser(selectedUser);
		
		if(selectedUser.getRole().equals(ROLE.ADMIN.getName())) {
			adminDAO.deleteUser(selectedUser);
		}
		else if (selectedUser.getRole().equals(ROLE.TEACHER.getName())) {
			teacherDAO.deleteUser(selectedUser);
		}
		else {
			studentDAO.deleteUser(selectedUser);
		}
		search();
		
		
	}

	@Override
	public void userSelected(User user) {
		selectedUser = user;
	}
	
	public void viewUsers() {
		stateChanged();
		adminPanel.setPanel(adminManageUsers);
	}

	private void stateChanged() {
		usersList = usersDAO.getAllUsers();
		adminManageUsers.populate(usersList);
		
	}

	@Override
	public void search() {
		String searchString = adminManageUsers.getSearchString();
		usersList = usersDAO.getUsers(searchString);
		adminManageUsers.populate(usersList);
	}

}
