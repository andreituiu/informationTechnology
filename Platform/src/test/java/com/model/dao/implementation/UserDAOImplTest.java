package com.model.dao.implementation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.controllers.common.implementation.ROLE;
import com.model.User;
import com.model.dao.UserDAO;

public class UserDAOImplTest extends UnitilsTestNG{

	private static final String CNP = null;
	private static final String NAME = null;
	private static final String SURNAME = null;
	private UserDAO userDAO;
	private Utils utils;
	
	

	public UserDAOImplTest() {
		super();
		utils = new Utils();
		userDAO = utils.userDAO;
	}

	@BeforeTest
	public void init() {
		utils.init();
	}
	
	@AfterTest
	public void destory() {
		utils.destroy();
	}
	
	@Test
	public void testDeleteUser() {
		User user = new User();
		user.setCnp(Utils.STUDENT_CNP);
		userDAO.deleteUser(user);
		Assert.assertNull(userDAO.getUser(Utils.STUDENT_CNP));
	}
	
	@Test 
	public void testGetAllUsers() {
		List<User> users = userDAO.getAllUsers();
		Assert.assertFalse(users.isEmpty());
	}
	
	@Test
	public void testGetUser() {
		
		User user = userDAO.getUser(Utils.STUDENT_CNP);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getCnp(), Utils.STUDENT_CNP);
		Assert.assertEquals(user.getName(), Utils.STUDENT_NAME);
		Assert.assertEquals(user.getSurname(), Utils.STUDENT_SURNAME);
		Assert.assertEquals(user.getRole(), ROLE.STUDENT.getName());
		
		userDAO.deleteUser(user);
	}
	
	@Test
	public void testGetUsers() {
		List<User> users = userDAO.getUsers(Utils.STUDENT_NAME);
		Assert.assertFalse(users.isEmpty());
	}
}
