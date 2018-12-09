package com.views.teacher;

import javax.swing.JPanel;

public class TeacherPanel extends JPanel{
	private JPanel currentPannel;
	TeacherHeader header;
	
	public TeacherPanel(TeacherHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		header.setLocation(0, 0);
		header.setSize(450, 53);
		
		currentPannel = new TeacherProfileInformationPanel();
		currentPannel.setLocation(0, 52);
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
