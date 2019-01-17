package com.views.admin;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminFrame extends JFrame{
	
	@Autowired
	private AdminPanel adminPanel;

	public AdminFrame(AdminPanel adminPanel) throws HeadlessException {
		super();
		this.adminPanel = adminPanel;
	
		initialize();
	}

	
	
	public AdminFrame() throws HeadlessException {
		super();
	}


	@PostConstruct
	private void initialize() {
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(215, 228, 242));
		adminPanel.setLocation(0, 0);
		adminPanel.setSize(1000, 700);
		getContentPane().add(adminPanel);
		setSize(1000, 700);
		setResizable(false);
	}
}
