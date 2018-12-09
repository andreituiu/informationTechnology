package com.controllers.common;

import com.model.Mail;
import com.views.common.MailPanel;
import com.views.student.StudentPanel;

public interface IEmailPanelController {

	void viewEmail();

	void sendEmail();

    void update();

    void setMailPanel(MailPanel mailPanel);

    void setStudentPanel(StudentPanel studentPanel);

    void selectedInboxMail(Mail mail);

}
