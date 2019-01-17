package com.model.dao;

import java.util.List;

import com.model.Mail;
import com.model.User;

public interface MailDAO {

	void sendMail(Mail mail);

    List<Mail> getInboxMails(User user);

    List<Mail> getSentMails(User user);

}
