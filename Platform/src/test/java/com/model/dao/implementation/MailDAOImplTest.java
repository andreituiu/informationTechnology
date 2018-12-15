package com.model.dao.implementation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Mail;
import com.model.User;
import com.model.dao.MailDAO;

public class MailDAOImplTest extends UnitilsTestNG{

	private MailDAO mailDAO;
	private Utils utils;
	
	

	public MailDAOImplTest() {
		super();
		utils = new Utils();
		mailDAO = utils.mailDAO;
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
	public void testGetInboxEmail() {
		User user = new User();
		user.setCnp(Utils.STUDENT_CNP);
		List<Mail> mails = mailDAO.getInboxMails(user);
		Assert.assertFalse(mails.isEmpty());
	}
	
	@Test
	public void testGetSentEmail() {
		User user = new User();
		user.setCnp(Utils.STUDENT_CNP);
		List<Mail> mails = mailDAO.getSentMails(user);
		Assert.assertFalse(mails.isEmpty());
	}
}
