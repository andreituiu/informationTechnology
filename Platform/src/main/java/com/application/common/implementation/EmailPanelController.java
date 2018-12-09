package com.application.common.implementation;

import com.controllers.common.IEmailPanelController;
import com.model.Mail;
import com.model.dao.MailDAO;
import com.views.common.MailPanel;

public class EmailPanelController implements IEmailPanelController {

	private MailPanel mailPanel;
	private MailDAO mailDAO;

	@Override
	public void viewEmail() {

	}

	@Override
	public void sendEmail() {
		String to = mailPanel.getTo();
		String cc = mailPanel.getCc();
		String subject = mailPanel.getSubject();
		String message = mailPanel.getMessage();
		
		String toCnp;
		String fromCnp;
		Mail mail = new Mail(toCnp, fromCnp, subject, message);
		mailDAO.sendMail(mail);
	}

}
