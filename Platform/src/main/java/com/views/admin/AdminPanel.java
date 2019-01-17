package com.views.admin;

import java.awt.Color;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.views.common.ISupportPanel;

@Component(value = "adminPanel")
public class AdminPanel extends JPanel implements ISupportPanel {

	@Autowired
	@Qualifier("adminProfile")
	private JPanel currentPannel;

	@Autowired
	private AdminHeader header;

	public AdminPanel(AdminHeader header, JPanel startingPannel) {

		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	public AdminPanel() {
		super();
	}

	@PostConstruct
	private void initialize() {
		setBackground(new Color(215, 228, 242));

		header.setLocation(12, 13);
		header.setSize(932, 56);

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
