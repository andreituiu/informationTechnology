package com.controllers.common;

import com.model.Mail;
import com.model.User;
import com.views.common.ISupportPanel;
import com.views.common.MailPanel;
import com.views.student.StudentPanel;

public interface IEmailPanelController {

	void viewEmail();

	void sendEmail();

    void update();

    void setMailPanel(MailPanel mailPanel);

    void selectedInboxMail(Mail mail);

	void setSupportPanel(ISupportPanel supportPanel);

	void setUser(User user);

}
