package com.controllers.admin.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateUserController;
import com.controllers.admin.IAdminManageUsersController;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;
import com.model.dao.UserDAO;
import com.model.repository.AdminRepository;
import com.model.repository.StudentRepository;
import com.model.repository.TeacherRepository;
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
	private AdminRepository adminRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ManageUsers adminManageUsers;
	
	List<User> usersList;

	private User selectedUser;

	@Autowired
	private AdminPanel adminPanel;
	
	

	public AdminManageUsersController(UserDAO usersDAO, AdminDAO adminDAO, TeacherDAO teacherDAO, StudentDAO studentDAO,
			IAdminCreateUserController adminCreateUserController) {
		super();
		this.usersRepository = usersDAO;
		this.adminRepository = adminDAO;
		this.teacherRepository = teacherDAO;
		this.studentRepository = studentDAO;
		this.adminCreateUserController = adminCreateUserController;
	}
	
	
	
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
	public void openModifyUserFrame(Object selectedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User selectedUser) {
	
		usersRepository.deleteUser(selectedUser);
		
		if(selectedUser.getRole().equals("admin")) {
			adminRepository.deleteUser(selectedUser);
		}
		else if (selectedUser.getRole().equals("teacher")) {
			teacherRepository.deleteUser(selectedUser);
		}
		else {
			studentRepository.deleteUser(selectedUser);
		}
		
		
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
		usersList = usersRepository.findAll();
		adminManageUsers.populate(usersList);
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}

}
