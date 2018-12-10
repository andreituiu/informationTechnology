package com.views.teacher;

import javax.swing.JPanel;

import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TeacherManageStudentsPanel extends JPanel{
    private TeacherStudentsTablePanel waitingStudentsTablePanel;
    private TeacherStudentsTablePanel enrolledStudentsTablePanel;
    private ITeacherManageStudentsPanelController teacherManageStudentsPanelController;

    
    
    
    public TeacherManageStudentsPanel(ITeacherManageStudentsPanelController teacherManageStudentsPanelController,
			TeacherStudentsTablePanel waitingStudentsTablePanel, TeacherStudentsTablePanel enrolledStudentsTablePanel) {
		super();
		this.teacherManageStudentsPanelController = teacherManageStudentsPanelController;
		this.waitingStudentsTablePanel = waitingStudentsTablePanel;
		this.enrolledStudentsTablePanel = enrolledStudentsTablePanel;

		initialize();
	}

	private void initialize(){
    	 setLayout(null);
    	 
//    	 waitingStudentsTablePanel = new TeacherStudentsTablePanel();
//    	 enrolledStudentsTablePanel = new TeacherStudentsTablePanel();
    	 
         waitingStudentsTablePanel.setLocation(0, 11);
         waitingStudentsTablePanel.setSize(295, 111);
         enrolledStudentsTablePanel.setSize(303, 111);
         enrolledStudentsTablePanel.setLocation(0, 167);
         
         add(waitingStudentsTablePanel);
         add(enrolledStudentsTablePanel);
         
         JButton btnAccept = new JButton("Accept");
         btnAccept.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
             }
         });
         btnAccept.setBounds(305, 58, 77, 23);
         add(btnAccept);
         
         JButton btnRemove = new JButton("Remove");
         btnRemove.setBounds(305, 215, 77, 23);
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
