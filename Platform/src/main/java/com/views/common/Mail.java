package com.views.common;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Mail extends JPanel{
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public Mail() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"From", "Subject", "Date"
			}
		));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		JPanel Sent = new JPanel();
		tabbedPane.addTab("Sent", null, Sent, null);
		Sent.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 405, 175);
		Sent.add(scrollPane_1);
		
		table_1 = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"From", "Subject", "Date"
			}
		));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(table_1);
		
		JPanel Compose = new JPanel();
		tabbedPane.addTab("Compose", null, Compose, null);
		Compose.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 294, 20);
		Compose.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 34, 294, 20);
		Compose.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 57, 294, 20);
		Compose.add(textField_2);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(326, 33, 89, 23);
		Compose.add(btnSend);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 84, 405, 102);
		Compose.add(textField_3);
		textField_3.setColumns(10);
	}
}
