package com.controllers.common.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.model.Mail;
import com.model.User;
import com.model.dao.MailDAO;
import com.model.repository.MailRepository;
import com.views.common.ISupportPanel;
import com.views.common.MailPanel;

@Component
public class EmailPanelController implements IEmailPanelController {

	@Autowired
    private MailPanel mailPanel;
    private User user;
    
    
    private ISupportPanel supportPanel;

    @Autowired
    private MailRepository mailRepository;
    
    public EmailPanelController(MailRepository mailDAO, User user) {
        super();
        this.mailRepository = mailDAO;
        this.user = user;
    }
    
    
    public EmailPanelController() {
		super();
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
        mailRepository.sendMail(mail);
    }

    @Override
    public void update() {
        List<Mail> inboxMails = mailRepository.findAll();
        List<Mail> sentMails = mailRepository.findAll();
        mailPanel.setInboxMail(inboxMails);
        mailPanel.setSentMail(sentMails);
    }

    @Override
    public void selectedInboxMail(Mail mail) {
        mailPanel.setInboxMailMessage(mail.getMessage());
    }
    
    

}
