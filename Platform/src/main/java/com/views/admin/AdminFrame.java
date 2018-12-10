package com.views.admin;

import java.awt.HeadlessException;

import javax.swing.JFrame;


public class AdminFrame extends JFrame{
	
	private AdminPanel adminPanel;

	public AdminFrame(AdminPanel adminPanel) throws HeadlessException {
		super();
		this.adminPanel = adminPanel;
	
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);

		adminPanel.setLocation(0, 0);
		adminPanel.setSize(476, 400);
		getContentPane().add(adminPanel);
	}
}
