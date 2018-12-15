package com.controllers.common.implementation;

import java.util.List;

import javax.swing.JPanel;

import com.controllers.common.IEmailPanelController;
import com.model.Mail;
import com.model.User;
import com.model.dao.MailDAO;
import com.views.common.ISupportPanel;
import com.views.common.MailPanel;
import com.views.student.StudentPanel;


public class EmailPanelController implements IEmailPanelController {

    private MailDAO mailDAO;
    private MailPanel mailPanel;
    private User user;
    private ISupportPanel supportPanel;

    
    
    public EmailPanelController(MailDAO mailDAO, User user) {
        super();
        this.mailDAO = mailDAO;
        this.user = user;
    }

    public EmailPanelController(MailDAO mailDAO) {
		this.mailDAO = mailDAO;

    }
    
    @Override
    public void viewEmail() {
    	supportPanel.setPanel(mailPanel);
    }
    
    
    @Override
    public void setSupportPanel(ISupportPanel supportPanel) {
		this.supportPanel = supportPanel;
	}

	@Override
    public void setMailPanel(MailPanel mailPanel) {
        this.mailPanel = mailPanel;
    }

    @Override
    public void sendEmail() {
        String toCnp = mailPanel.getTo();
        String fromCnp = user.getCnp();
        String subject = mailPanel.getSubject();
        String message = mailPanel.getMessage();
        Mail mail = new Mail(toCnp, fromCnp, subject, message);
        mailDAO.sendMail(mail);
    }

    @Override
    public void update() {
        List<Mail> inboxMails = mailDAO.getInboxMails(user);
        List<Mail> sentMails = mailDAO.getSentMails(user);
        mailPanel.setInboxMail(inboxMails);
        mailPanel.setSentMail(sentMails);
    }

    @Override
    public void selectedInboxMail(Mail mail) {
        mailPanel.setInboxMailMessage(mail.getMessage());
    }

	@Override
	public void setUser(User user) {
		this.user = user;
	}
    
    

}
