package com.views.teacher;

import java.awt.Color;

import javax.annotation.PostConstruct;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.views.common.ISupportPanel;
import com.views.common.MailPanel;

@Component
public class TeacherPanel extends JPanel implements ISupportPanel {
	
	@Autowired
	@Qualifier("teacherProfileInformationPanel")
	private JPanel currentPannel;

	@Autowired
	private TeacherHeader header;

	public TeacherPanel(TeacherHeader header, JPanel startingPannel) {
		currentPannel = startingPannel;
		this.header = header;
		initialize();
	}

	
	
	public TeacherPanel() {
		super();
	}



	@PostConstruct
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
