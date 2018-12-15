package com.views.student;

import java.awt.Color;

import javax.swing.JPanel;

import com.views.common.ILanguagePanel;
import com.views.common.ISupportPanel;
import com.views.common.MailPanel;

public class StudentPanel extends JPanel implements ISupportPanel{
	private JPanel currentPannel;
	private StudentHeader header;
	
	public StudentPanel(StudentHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		setBackground(new Color(215, 228, 242));
		
//		header = new StudentHeader(null);
		header.setLocation(58, 13);
		header.setSize(837, 56);
		
//		currentPannel = new MailPanel(null);
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
