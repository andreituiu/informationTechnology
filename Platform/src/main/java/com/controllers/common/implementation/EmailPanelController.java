package com.controllers.common.implementation;

import java.util.List;

import com.controllers.common.IEmailPanelController;
import com.model.Mail;
import com.model.User;
import com.model.dao.MailDAO;
import com.views.common.MailPanel;
import com.views.student.StudentPanel;


public class EmailPanelController implements IEmailPanelController {

    private MailDAO mailDAO;
    private MailPanel mailPanel;
    private User user;
    private StudentPanel studentPanel;

    
    
    public EmailPanelController(MailDAO mailDAO, User user) {
        super();
        this.mailDAO = mailDAO;
        this.user = user;
    }

    @Override
    public void viewEmail() {
        studentPanel.setPanel(mailPanel);
    }
    
    
    @Override
    public void setStudentPanel(StudentPanel studentPanel) {
        this.studentPanel = studentPanel;
    }

    @Override
    public void setMailPanel(MailPanel mailPanel) {
        this.mailPanel = mailPanel;
    }

    @Override
    public void sendEmail() {
        String toCnp = mailPanel.getTo();
        String fromCnp = user.getCNP();
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
    
    

}
