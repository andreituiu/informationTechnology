package com.controllers.common.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.model.Mail;
import com.model.User;
import com.model.repository.MailRepository;
import com.model.repository.UserRepository;
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

	@Autowired
	private UserRepository userRepository;

	public EmailPanelController(MailRepository mailDAO, User user) {
		super();
		this.mailRepository = mailDAO;
		this.user = user;
	}

	public EmailPanelController() {
		super();
	}

	@PostConstruct
	public void initMailPanel() {
		mailPanel.setMailPanelController(this);
	}

	@Override
	public void viewEmail() {
		supportPanel.setPanel(mailPanel);
		update();
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
		String subject = mailPanel.getSubject();
		String message = mailPanel.getMessage();

		Optional<User> optionalUser = userRepository.findByInternalEmail(toCnp);

		if (optionalUser.isPresent() == false) {
			ResourceBundle languageBundle = mailPanel.getLanguageBundle();
			String popupMessage = "User not found";
			if (languageBundle != null) {
				popupMessage = languageBundle.getString("user.notfoud");
			}
			mailPanel.showPopup(popupMessage);
			return;
		}
		Date currentDate = new Date();
		Mail mail = new Mail(user, optionalUser.get(), subject, message, currentDate);
		optionalUser.get().getRecievedMails().add(mail);
		user.getSentMails().add(mail);
		mailRepository.save(mail);
		mailPanel.clearCreateMessageFields();
	}

	@Override
	public void update() {
		mailPanel.setMailPanelController(this);
		List<Mail> inboxMails = new ArrayList<>(user.getRecievedMails());
		List<Mail> sentMails = new ArrayList<>(user.getSentMails());
		mailPanel.setInboxMail(inboxMails);
		mailPanel.setSentMail(sentMails);
	}

	@Override
	public void selectedInboxMail(Mail mail) {
		if (mail == null) {
			mailPanel.setInboxMailMessage("");
		} else {
			mailPanel.setInboxMailMessage(mail.getMessage());
		}
	}

	@Override
	public void selectedSentMail(Mail mail) {
		if (mail == null) {
			mailPanel.setSentMailMessage("");
		} else {
			mailPanel.setSentMailMessage(mail.getMessage());
		}
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

}
