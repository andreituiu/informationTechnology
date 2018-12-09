package com.views.student;

import java.awt.Component;

import javax.swing.JPanel;

public class StudentPanel extends JPanel{
	private JPanel currentPannel;
	private StudentHeader header;
	
	public StudentPanel(StudentHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		header.setLocation(0, 0);
		header.setSize(450, 53);
		
		currentPannel = new StudentProfileInformationPanel();
		currentPannel.setLocation(0, 0);
		currentPannel.setSize(450, 349);
		
		setLayout(null);
		
		add(header);
		add(currentPannel);
	}

	public void setPanel(JPanel newPannel) {
		remove(currentPannel);
		currentPannel = newPannel;
		add(currentPannel);
		currentPannel.setLocation(0, 52);
		currentPannel.setSize(450, 349);
	}
}
