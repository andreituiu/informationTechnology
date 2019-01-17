package com.views.teacher;

import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Student;

import javax.annotation.PostConstruct;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@Component
public class TeacherManageStudentsPanel extends JPanel{
	
	@Autowired
	@Qualifier("waitingStudentsTablePanel")
    private TeacherStudentsTablePanel waitingStudentsTablePanel;
    
	@Autowired
	@Qualifier("enrolledStudentsTablePanel")
	private TeacherStudentsTablePanel enrolledStudentsTablePanel;
    
	@Autowired
	private ITeacherManageStudentsPanelController teacherManageStudentsPanelController;

    
    
    
    public TeacherManageStudentsPanel(ITeacherManageStudentsPanelController teacherManageStudentsPanelController,
			TeacherStudentsTablePanel waitingStudentsTablePanel, TeacherStudentsTablePanel enrolledStudentsTablePanel) {
		super();
		this.teacherManageStudentsPanelController = teacherManageStudentsPanelController;
		this.waitingStudentsTablePanel = waitingStudentsTablePanel;
		this.enrolledStudentsTablePanel = enrolledStudentsTablePanel;

		initialize();
	}

    
    
	public TeacherManageStudentsPanel() {
		super();
	}


	@PostConstruct
	private void initialize(){
    	 setLayout(null);
    	 setBackground(new Color(215, 228, 242));
//  	 waitingStudentsTablePanel = new TeacherStudentsTablePanel();
//   	 enrolledStudentsTablePanel = new TeacherStudentsTablePanel();
    	 
         waitingStudentsTablePanel.setLocation(0, 25);
         waitingStudentsTablePanel.setSize(579, 205);
         enrolledStudentsTablePanel.setSize(579, 194);
         enrolledStudentsTablePanel.setLocation(0, 242);
         
         add(waitingStudentsTablePanel);
         add(enrolledStudentsTablePanel);
         
         JButton btnAccept = new JButton("Accept");
         btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 15));
         btnAccept.setBounds(591, 35, 109, 35);
         add(btnAccept);
         
         JButton btnRemove = new JButton("Remove");
         btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
         btnRemove.setBounds(591, 252, 109, 35);
         add(btnRemove);
         
         btnAccept.addActionListener(new ActionListener() {
             
             @Override
             public void actionPerformed(ActionEvent e) {
                 teacherManageStudentsPanelController.acceptStudent(waitingStudentsTablePanel.getSelectedStudent());
             }
         });
         
         btnRemove.addActionListener(new ActionListener() {
             
             @Override
             public void actionPerformed(ActionEvent e) {
                 teacherManageStudentsPanelController.removeStudent(enrolledStudentsTablePanel.getSelectedStudent());
             }
         });
    }

    public void populateWaitingStudents(List<Student> waitingStudents) {
        waitingStudentsTablePanel.populate(waitingStudents);
    }

    public void populateEnrolledStudents(List<Student> enrolledStudents) {
        enrolledStudentsTablePanel.populate(enrolledStudents);
    }
}
