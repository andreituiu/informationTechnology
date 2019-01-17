package com.views.common;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.model.Course;
import com.model.Mail;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

@Component(value = "mailPanel")
public class MailPanel extends JPanel implements ILanguagePanel {
	private JTable inboxTable;
	private JTable sentTable;
	private JTextField toTextField;
	private JTextField ccTextField;
	private JTextField subjectTtextField;
	private JTextField messageTextField;
	private JButton btnSend;
	private JTabbedPane tabbedPane;
	private List<Mail> sentMails;
	private List<Mail> inboxMails;

	private IEmailPanelController mailPanelController;

	public MailPanel(IEmailPanelController mailPanelController) {
		this.mailPanelController = mailPanelController;
		initialize();
	}

	public MailPanel() {
		super();
	}
	
	public void setMailPanelController(IEmailPanelController mailPanelController) {
		this.mailPanelController = mailPanelController;
	}

	@PostConstruct
	public void initialize() {
		setLayout(null);
		setBackground(new Color(215, 228, 242));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(12, 13, 769, 471);
		add(tabbedPane);

		JPanel Sent = new JPanel();
		tabbedPane.addTab("Sent", null, Sent, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 255));
		Sent.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 766, 441);
		Sent.add(scrollPane_1);

		sentTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "To", "Subject", "Date" }));
		sentTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane_1.setViewportView(sentTable);

		JPanel Compose = new JPanel();
		tabbedPane.addTab("Compose", null, Compose, null);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 255));
		Compose.setLayout(null);

		toTextField = new JTextField();
		toTextField.setBounds(27, 28, 450, 31);
		Compose.add(toTextField);
		toTextField.setColumns(10);

		ccTextField = new JTextField();
		ccTextField.setColumns(10);
		ccTextField.setBounds(27, 72, 450, 31);
		Compose.add(ccTextField);

		subjectTtextField = new JTextField();
		subjectTtextField.setColumns(10);
		subjectTtextField.setBounds(27, 116, 450, 31);
		Compose.add(subjectTtextField);

		btnSend = new JButton("Send");
		btnSend.setBounds(521, 26, 209, 35);
		Compose.add(btnSend);

		messageTextField = new JTextField();
		messageTextField.setBounds(27, 206, 707, 193);
		Compose.add(messageTextField);
		messageTextField.setColumns(10);

		JPanel Inbox = new JPanel();
		Inbox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Inbox", null, Inbox, null);
		tabbedPane.setForegroundAt(2, new Color(0, 0, 255));
		Inbox.setLayout(null);

		JPanel mailDetails = new JPanel();
		mailDetails.setBounds(28, 315, 724, 102);
		mailDetails.setBackground(Color.WHITE);
		Inbox.add(mailDetails);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(28, 13, 724, 308);
		Inbox.add(scrollPane);

		inboxTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "From", "Subject", "Date" }));
		inboxTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(inboxTable);

		inboxTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				int selectedRow = inboxTable.getSelectedRow();
				mailPanelController.selectedInboxMail(inboxMails.get(selectedRow));
			}
		});

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mailPanelController.sendEmail();
			}
		});

		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				mailPanelController.update();
			}
		});
	}

	@Override
	public void setLanguageBundle(ResourceBundle languageBundle) {
		tabbedPane.setTitleAt(0, languageBundle.getString("inbox"));
		tabbedPane.setTitleAt(1, languageBundle.getString("sent"));
		tabbedPane.setTitleAt(2, languageBundle.getString("compose"));
		btnSend.setText(languageBundle.getString("send"));
	}

	public String getTo() {
		return toTextField.getText();
	}

	public String getCc() {
		return null;
	}

	public String getSubject() {
		return subjectTtextField.getText();
	}

	public String getMessage() {
		return messageTextField.getText();
	}

	public void setSentMail(List<Mail> sentMails) {
		this.sentMails = sentMails;
		eraseSentTable();
		DefaultTableModel tableModel = (DefaultTableModel) sentTable.getModel();
		for (Mail mail : sentMails) {
			Object[] newRow = { mail.getToCnp(), mail.getSubject(), "" };
			tableModel.addRow(newRow);
		}
	}

	private void eraseSentTable() {
		DefaultTableModel tableModel = (DefaultTableModel) sentTable.getModel();
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	public void setInboxMail(List<Mail> inboxMails) {
		this.inboxMails = inboxMails;
		eraseInboxTable();
		DefaultTableModel tableModel = (DefaultTableModel) inboxTable.getModel();
		for (Mail mail : inboxMails) {
			Object[] newRow = { mail.getFromCnp(), mail.getSubject(), "" };
			tableModel.addRow(newRow);
		}
	}

	private void eraseInboxTable() {
		DefaultTableModel tableModel = (DefaultTableModel) inboxTable.getModel();
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	public void setInboxMailMessage(String message) {
	}
}
