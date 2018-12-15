package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Admin;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.mapper.AdminMapper;

public class AdminDAOImplTest extends UnitilsTestNG{

	private AdminDAO adminDAO;
	private Utils utils;
	

	public AdminDAOImplTest() {
		super();
		utils = new Utils();
		adminDAO = utils.adminDAO;
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
	public void testGetAdmin() {
		Admin admin = adminDAO.getAdmin(Utils.ADMIN_CNP);
		Assert.assertEquals(admin.getName(), Utils.ADMIN_NAME);
		Assert.assertEquals(admin.getSurname(), Utils.ADMIN_SURNAME);
		Assert.assertEquals(admin.getPassword(), Utils.ADMIN_PASSWORD);
		Assert.assertEquals(admin.getCnp(), Utils.ADMIN_CNP);
		Assert.assertEquals(admin.getExternalEmail(), Utils.ADMIN_EXTERNAL_EMAIL);
		Assert.assertEquals(admin.getInternalEmail(), Utils.ADMIN_INETERNAL_EMAIL);
	}
	
	@Test
	public void testUpdate() {
		
		Admin admin = adminDAO.getAdmin(Utils.ADMIN_CNP);
		String externalEmail = "newExternalEmail";
		admin.setExternalEmail(externalEmail);
		adminDAO.update(admin);
		admin = adminDAO.getAdmin(Utils.ADMIN_CNP);
		Assert.assertEquals(admin.getExternalEmail(), externalEmail);
	}
	
//	@AfterSuite
//	public void testDeleteUser() {
//		User user = new User();
//		user.setCnp(ADMIN_CNP);
//		adminDAO.deleteUser(user);
//		Admin admin = adminDAO.getAdmin(ADMIN_CNP);
//		Assert.assertNull(admin);
//	}
}
