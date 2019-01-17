package com.views.common;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.controllers.common.IEmailPanelController;
import com.model.Mail;

@Component(value = "mailPanel")
public class MailPanel extends JPanel implements ILanguagePanel {
	private JTable inboxTable;
	private JTable sentTable;
	private JTextField toTextField;
	private JTextField subjectTtextField;
	private JTextArea composeMessageTextField;
	private JButton btnSend;
	private JTabbedPane tabbedPane;
	private List<Mail> sentMails;
	private List<Mail> inboxMails;

	private IEmailPanelController mailPanelController;
	private JTextArea inboxMailDetails;
	private ResourceBundle languageBundle;
	private JTextArea sentMailDetails;

	// public MailPanel(IEmailPanelController mailPanelController) {
	// this.mailPanelController = mailPanelController;
	// initialize();
	// }

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

		JPanel Inbox = new JPanel();
		Inbox.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Inbox", null, Inbox, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 255));
		Inbox.setLayout(null);
		inboxMailDetails = new JTextArea();
		inboxMailDetails.setBounds(28, 315, 724, 102);
		inboxMailDetails.setBackground(Color.WHITE);
		inboxMailDetails.setLineWrap(true);
		inboxMailDetails.setWrapStyleWord(true);
		inboxMailDetails.setEditable(false);
		JScrollPane scrollpaneInboxDetails = new JScrollPane(inboxMailDetails);
		scrollpaneInboxDetails.setBounds(28, 315, 724, 102);
		Inbox.add(scrollpaneInboxDetails);

		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(28, 13, 724, 308);
		Inbox.add(scrollPane);

		inboxTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "From", "Subject", "Date" }));
		inboxTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		inboxTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(inboxTable);

		inboxTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				int selectedRow = inboxTable.getSelectedRow();
				mailPanelController.selectedInboxMail(inboxMails.get(selectedRow));
			}
		});

		JPanel Sent = new JPanel();
		tabbedPane.addTab("Sent", null, Sent, null);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 255));
		Sent.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 13, 724, 308);
		
		sentMailDetails = new JTextArea();
		sentMailDetails.setBounds(28, 315, 724, 102);
		sentMailDetails.setBackground(Color.WHITE);
		sentMailDetails.setLineWrap(true);
		sentMailDetails.setWrapStyleWord(true);
		sentMailDetails.setEditable(false);
		JScrollPane scrollpaneSentDetails = new JScrollPane(sentMailDetails);
		scrollpaneSentDetails.setBounds(28, 315, 724, 102);
		Sent.add(scrollpaneSentDetails);
		Sent.add(scrollPane_1);

		sentTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "To", "Subject", "Date" }));
		sentTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		sentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		sentTable.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				int selectedRow = sentTable.getSelectedRow();
				mailPanelController.selectedInboxMail(sentMails.get(selectedRow));
			}
		});
		scrollPane_1.setViewportView(sentTable);

		JPanel Compose = new JPanel();
		tabbedPane.addTab("Compose", null, Compose, null);
		tabbedPane.setForegroundAt(2, new Color(0, 0, 255));
		Compose.setLayout(null);

		toTextField = new JTextField();
		toTextField.setBounds(27, 28, 450, 31);
		Compose.add(toTextField);
		toTextField.setColumns(10);

		subjectTtextField = new JTextField();
		subjectTtextField.setColumns(10);
		subjectTtextField.setBounds(27, 70, 450, 31);
		Compose.add(subjectTtextField);

		btnSend = new JButton("Send");
		btnSend.setBounds(521, 26, 209, 35);
		Compose.add(btnSend);

		composeMessageTextField = new JTextArea();
		composeMessageTextField.setBounds(27, 112, 707, 287);
		composeMessageTextField.setLineWrap(true);
		composeMessageTextField.setWrapStyleWord(true);
		
		JScrollPane scrollpaneComposeMessage = new JScrollPane(composeMessageTextField);
		scrollpaneComposeMessage.setBounds(27, 112, 707, 287);
		
		Compose.add(scrollpaneComposeMessage);

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
		this.languageBundle = languageBundle;
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
		return composeMessageTextField.getText();
	}

	public void setSentMail(List<Mail> sentMails) {
		this.sentMails = sentMails;
		eraseSentTable();
		DefaultTableModel tableModel = (DefaultTableModel) sentTable.getModel();
		for (Mail mail : sentMails) {
			Object[] newRow = { mail.getReciever().getCnp(), mail.getSubject(), mail.getSentDate() };
			tableModel.addRow(newRow);
		}
		if(sentMails.isEmpty() == false) {
			sentTable.setRowSelectionInterval(0, 0);
			mailPanelController.selectedSentMail(sentMails.get(0));
		} else {
			mailPanelController.selectedSentMail(null);
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
			Object[] newRow = { mail.getSender().getCnp(), mail.getSubject(), mail.getSentDate() };
			tableModel.addRow(newRow);
		}
		if(inboxMails.isEmpty() == false) {
			inboxTable.setRowSelectionInterval(0, 0);
			mailPanelController.selectedInboxMail(inboxMails.get(0));
		} else {
			mailPanelController.selectedInboxMail(null);
		}
	}

	private void eraseInboxTable() {
		DefaultTableModel tableModel = (DefaultTableModel) inboxTable.getModel();
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}

	public void setInboxMailMessage(String message) {
		inboxMailDetails.setText(message);
	}
	
	public void setSentMailMessage(String message) {
		sentMailDetails.setText(message);
	}

	public ResourceBundle getLanguageBundle() {
		return languageBundle;
	}

	public void showPopup(String message) {
		JOptionPane.showMessageDialog(this, message);		
	}

	public void clearCreateMessageFields() {
		toTextField.setText("");
		subjectTtextField.setText("");
		composeMessageTextField.setText("");
	}
	
	
}
