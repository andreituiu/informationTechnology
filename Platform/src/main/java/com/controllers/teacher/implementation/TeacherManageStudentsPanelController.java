package com.controllers.teacher.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Course;
import com.model.Student;
import com.model.dao.StudentDAO;
import com.model.repository.StudentRepository;
import com.views.teacher.TeacherManageStudentsPanel;

@Component
public class TeacherManageStudentsPanelController implements ITeacherManageStudentsPanelController {

	@Autowired
    private TeacherManageStudentsPanel teacherManageStudentsPanel;
    private Course course;

    @Autowired
    private StudentRepository studentRepository;
    

    public TeacherManageStudentsPanelController(StudentDAO studentDAO) {
		super();
		this.studentRepository = studentDAO;
	}
    
    

	public TeacherManageStudentsPanelController() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
    public void courseSelected(Course course) {
        
        this.course = course;
        List<Student> waitingStudents = new ArrayList<>(course.getPendingStudents());
        List<Student> enrolledStudents = new ArrayList<>(course.getEnrolledStudents());
        teacherManageStudentsPanel.populateWaitingStudents(waitingStudents);
        teacherManageStudentsPanel.populateEnrolledStudents(enrolledStudents);
        
    }

    @Override
    public void acceptStudent(Student selectedStudent) {
    	selectedStudent.getPendingCourses().remove(course);
    	selectedStudent.getEnrolledCourses().add(course);
    	studentRepository.save(selectedStudent);
    }

    @Override
    public void removeStudent(Student selectedStudent) {
    	selectedStudent.getEnrolledCourses().remove(course);
    	studentRepository.save(selectedStudent);
    }

    @Override
	public void setTeacherManageStudentsPanel(TeacherManageStudentsPanel teacherManageStudentsPanel) {
		this.teacherManageStudentsPanel = teacherManageStudentsPanel;
	}
    
    

}
