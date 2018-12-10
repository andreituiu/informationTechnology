package com.controllers.admin.implementation;

import com.controllers.admin.IAdminCreateUserController;
import com.model.User;
import com.views.admin.CreateUser;

public class AdminCreateUserController implements IAdminCreateUserController {
	
	private CreateUser adminCreateUsers;
	//private TeachearDAO teacherDAO;
	//private StudentDAO studentDAO;
	//private AdminDAO adminDAO;
	
	@Override
	public void saveUser() {
		// TODO Auto-generated method stub
		 User user = new User();
		 user.setName(adminCreateUsers.getName());
		 user.setSurname(adminCreateUsers.getSurname());
		 user.setCNP(adminCreateUsers.getCNP());
		
		 
		 //teacherDAO.saveNewUser(user);
	}

	@Override
	public void selectAdmin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectTeacher() {
		// TODO Auto-generated method stub
		
	}

}
