package com.views.teacher;

import java.awt.Color;

import javax.swing.JPanel;

import com.views.common.ISupportPanel;
import com.views.common.MailPanel;

public class TeacherPanel extends JPanel implements ISupportPanel {
	private JPanel currentPannel;
	TeacherHeader header;

	public TeacherPanel(TeacherHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	private void initialize() {
		setBackground(new Color(215, 228, 242));
//		header = new TeacherHeader(null);
		//currentPannel = new TeacherCoursesPanel(null, null, null);
		
//		currentPannel = new TeacherProfileInformationPanel();
		header.setLocation(39, 13);
		header.setSize(913, 58);
		currentPannel.setLocation(39, 86);
		currentPannel.setSize(913, 570);

		setLayout(null);

		add(header);
		add(currentPannel);
	}

	public void setPanel(JPanel newPannel) {
		remove(currentPannel);
		currentPannel = newPannel;
		add(currentPannel);
		currentPannel.setLocation(39, 86);
		currentPannel.setSize(913, 570);
		revalidate();
		repaint();
	}
}
