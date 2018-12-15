package com.views.admin;

import java.awt.Color;

import javax.swing.JPanel;

import com.views.common.ISupportPanel;
import com.views.common.MailPanel;

public class AdminPanel extends JPanel implements ISupportPanel{

	private JPanel currentPannel;
	private AdminHeader header;
	
	public AdminPanel(AdminHeader header, JPanel startingPannel) {
		
		
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		setBackground(new Color(215, 228, 242));
//		header = new AdminHeader(null);
		
		header.setLocation(12, 13);
		header.setSize(932, 56);
		
//		currentPannel = new MailPanel(null);
		currentPannel.setLocation(82, 82);
		currentPannel.setSize(798, 562);
		
		setLayout(null);
		
		add(header);
		add(currentPannel);
	}

	public void setPanel(JPanel newPannel) {
		remove(currentPannel);
		repaint();
		currentPannel = newPannel;
		add(currentPannel);
		currentPannel.setLocation(82, 82);
		currentPannel.setSize(1000, 1000);
	}
}
