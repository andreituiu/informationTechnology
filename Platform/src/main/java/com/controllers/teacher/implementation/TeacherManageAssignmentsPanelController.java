package com.controllers.teacher.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.dao.AssignmentDAO;
import com.model.dao.StudentDAO;
import com.model.repository.AssignmentRepository;
import com.model.repository.StudentRepository;
import com.views.teacher.TeacherManageAssignmentsPanel;

@Component
public class TeacherManageAssignmentsPanelController implements
        ITeacherManageAssignmentsPanelController {

	@Autowired
    private TeacherManageAssignmentsPanel teacherManageAssignmentsPanel;
    private Course course;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController;
    
    private StudentAssignment studentAssignment;
	private Student student;

	
	
    public TeacherManageAssignmentsPanelController(StudentDAO studentDAO, AssignmentDAO assignmentDAO,
			ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController) {
		super();
		this.studentRepository = studentDAO;
		this.assignmentRepository = assignmentDAO;
		this.teacherCreateAssignmentFrameController = teacherCreateAssignmentFrameController;
	}

    
    
	public TeacherManageAssignmentsPanelController() {
		super();
	}



	@Override
    public void courseSelected(Course course) {
        this.course = course;
        List<Assignment> assignments = new ArrayList<>(course.getAssignments());
        List<Student> students = new ArrayList<>(course.getEnrolledStudents());
        teacherManageAssignmentsPanel.setStudents(students);
        teacherManageAssignmentsPanel.setAssignments(assignments);
    }

    @Override
    public void assignmentSelected(Assignment assignment) {
    	if(student == null || assignment == null) {
    		return;
    	}
    	studentAssignment = null;
		Set<StudentAssignment> studentAssignments = student.getStudentAssignment();
		for(StudentAssignment studentAssignmentAux : studentAssignments) {
			if(studentAssignmentAux.getAssignment().equals(assignment)) {
				studentAssignment = studentAssignmentAux;
			}
		}
		if(studentAssignment == null) {
			return;
		}
		
        teacherManageAssignmentsPanel.setDeadline(studentAssignment.getDeadline());
        teacherManageAssignmentsPanel.setLastUpdate(studentAssignment.getLastUpdate());
        teacherManageAssignmentsPanel.setGrade(studentAssignment.getGrade());
    }
    
    @Override
    public void studentSelected(Student student) {
        this.student = student;
		List<Assignment> assignments = assignmentRepository.getAssignmentsFor(course);
        teacherManageAssignmentsPanel.setAssignments(assignments);
    }

    @Override
    public void createAssignment() {
        teacherCreateAssignmentFrameController.setCourse(course);
        teacherCreateAssignmentFrameController.openFrame();
    }

    @Override
    public void saveGrade() {
        Double grade = teacherManageAssignmentsPanel.getGrade();
        studentAssignment.setGrade(grade);
        assignmentRepository.save(studentAssignment);
    }

    @Override
	public void setTeacherManageAssignmentsPanel(TeacherManageAssignmentsPanel teacherManageAssignmentsPanel) {
		this.teacherManageAssignmentsPanel = teacherManageAssignmentsPanel;
	}

	@Override
	public void deleteStdent(Student selectedStudent) {
		studentRepository.removeFromCourse(selectedStudent, course);
		student = null;
		courseSelected(course);
	}
	
	@Override
	public void updateFields() {
		student = teacherManageAssignmentsPanel.getSelectedStudent();
		Assignment assignment = teacherManageAssignmentsPanel.getSelectedAssignment();
		
		if(student == null || assignment == null) {
    		return;
    	}
		studentAssignment = null;
		Set<StudentAssignment> studentAssignments = student.getStudentAssignment();
		for(StudentAssignment studentAssignmentAux : studentAssignments) {
			if(studentAssignmentAux.getAssignment().equals(assignment)) {
				studentAssignment = studentAssignmentAux;
			}
		}
		if(studentAssignment == null) {
			return;
		}
        teacherManageAssignmentsPanel.setDeadline(studentAssignment.getDeadline());
        teacherManageAssignmentsPanel.setLastUpdate(studentAssignment.getLastUpdate());
        teacherManageAssignmentsPanel.setGrade(studentAssignment.getGrade());
	}

    
    
}
