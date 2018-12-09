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

import com.controllers.common.IEmailPanelController;
import com.model.Course;
import com.model.Mail;

public class MailPanel extends JPanel{
	private JTable inboxTable;
	private JTable sentTable;
	private JTextField toTextField;
	private JTextField ccTextField;
	private JTextField subjectTtextField;
	private JTextField messageTextField;
	private JButton btnSend;
	private JTabbedPane tabbedPane;
	private IEmailPanelController mailPanelController;
    private List<Mail> sentMails;
    private List<Mail> inboxMails;
	
	public MailPanel(IEmailPanelController mailPanelController) {
	    this.mailPanelController = mailPanelController;
	    initialize();
	}
	
	public void initialize() {
		setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 11, 430, 225);
		add(tabbedPane);
		
		JPanel Inbox = new JPanel();
		tabbedPane.addTab("Inbox", null, Inbox, null);
		Inbox.setLayout(null);
		
		JPanel mailDetails = new JPanel();
		mailDetails.setBounds(10, 104, 405, 82);
		mailDetails.setBackground(Color.WHITE);
		Inbox.add(mailDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 405, 88);
		Inbox.add(scrollPane);
		
		inboxTable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"From", "Subject", "Date"
			}
		));
		inboxTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(inboxTable);
		
		JPanel Sent = new JPanel();
		tabbedPane.addTab("Sent", null, Sent, null);
		Sent.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 405, 175);
		Sent.add(scrollPane_1);
		
		sentTable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"To", "Subject", "Date"
			}
		));
		sentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(sentTable);
		
		JPanel Compose = new JPanel();
		tabbedPane.addTab("Compose", null, Compose, null);
		Compose.setLayout(null);
		
		toTextField = new JTextField();
		toTextField.setBounds(10, 11, 294, 20);
		Compose.add(toTextField);
		toTextField.setColumns(10);
		
		ccTextField = new JTextField();
		ccTextField.setColumns(10);
		ccTextField.setBounds(10, 34, 294, 20);
		Compose.add(ccTextField);
		
		subjectTtextField = new JTextField();
		subjectTtextField.setColumns(10);
		subjectTtextField.setBounds(10, 57, 294, 20);
		Compose.add(subjectTtextField);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(326, 33, 89, 23);
		Compose.add(btnSend);
		
		messageTextField = new JTextField();
		messageTextField.setBounds(10, 84, 405, 102);
		Compose.add(messageTextField);
		messageTextField.setColumns(10);
		
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
		
		inboxTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                int selectedRow = inboxTable.getSelectedRow();
                mailPanelController.selectedInboxMail(inboxMails.get(selectedRow));
            }
        });
	}
	
	public void setLanguageBundle(ResourceBundle languageBundle)  {
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
            Object[] newRow = {mail.getToCnp(), mail.getSubject(), ""};
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
            Object[] newRow = {mail.getFromCnp(), mail.getSubject(), ""};
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
	

