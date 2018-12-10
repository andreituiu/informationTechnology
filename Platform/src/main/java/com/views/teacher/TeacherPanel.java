package com.views.teacher;

import javax.swing.JPanel;

import com.views.common.ISupportPanel;

public class TeacherPanel extends JPanel implements ISupportPanel {
	private JPanel currentPannel;
	TeacherHeader header;

	public TeacherPanel(TeacherHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		// header = new TeacherHeader(null);
		// currentPannel = new TeacherCoursesPanel(null, null, null);

		header.setLocation(0, 0);
		header.setSize(450, 53);
		currentPannel.setLocation(0, 52);
		currentPannel.setSize(671, 349);

		setLayout(null);

		add(header);
		add(currentPannel);
	}

	public void setPanel(JPanel newPannel) {
		remove(currentPannel);
		currentPannel = newPannel;
		add(currentPannel);
		currentPannel.setLocation(0, 52);
		currentPannel.setSize(671, 349);
	}
}
