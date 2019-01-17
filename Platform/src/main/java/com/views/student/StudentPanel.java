package com.views.student;

import java.awt.Color;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.views.common.ISupportPanel;

@Component
public class StudentPanel extends JPanel implements ISupportPanel {

	@Autowired
	@Qualifier("studentProfileInformationPanel")
	private JPanel currentPannel;

	@Autowired
	private StudentHeader header;

	public StudentPanel() {
		super();
	}

	@PostConstruct
	private void initialize() {
		setBackground(new Color(215, 228, 242));

		header.setLocation(58, 13);
		header.setSize(837, 56);

		currentPannel.setLocation(85, 82);
		currentPannel.setSize(2000, 2000);

		setLayout(null);

		add(header);
		add(currentPannel);
	}

	public void setPanel(JPanel newPannel) {
		remove(currentPannel);
		repaint();
		currentPannel = newPannel;
		add(currentPannel);
		currentPannel.setLocation(85, 82);
		currentPannel.setSize(2000, 2000);
	}
}
