package com.views.admin;

import javax.swing.JPanel;

public class AdminPanel extends JPanel{

	private JPanel currentPannel;
	private AdminHeader header;
	
	public AdminPanel(AdminHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		header.setLocation(0, 0);
		header.setSize(450, 53);
		
		currentPannel = new AdminProfile();
		currentPannel.setLocation(0, 0);
		currentPannel.setSize(450, 349);
		
		setLayout(null);
		
		add(header);
		add(currentPannel);
	}

	public void setPanel(JPanel newPannel) {
		remove(currentPannel);
		repaint();
		currentPannel = newPannel;
		add(currentPannel);
		currentPannel.setLocation(0, 52);
		currentPannel.setSize(450, 349);
	}
}
