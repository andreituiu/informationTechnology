package com.controllers.teacher.implementation;

import java.util.List;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.dao.AssignmentDAO;
import com.model.dao.StudentDAO;
import com.views.teacher.TeacherManageAssignmentsPanel;

public class TeacherManageAssignmentsPanelController implements
        ITeacherManageAssignmentsPanelController {

    private TeacherManageAssignmentsPanel teacherManageAssignmentsPanel;
    private Course course;
    private StudentDAO studentDAO;
    private AssignmentDAO assignmentDAO;
    private ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController;
    private StudentAssignment studentAssignment;
	private Student student;

	
	
    public TeacherManageAssignmentsPanelController(StudentDAO studentDAO, AssignmentDAO assignmentDAO,
			ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController) {
		super();
		this.studentDAO = studentDAO;
		this.assignmentDAO = assignmentDAO;
		this.teacherCreateAssignmentFrameController = teacherCreateAssignmentFrameController;
	}

	@Override
    public void courseSelected(Course course) {
        this.course = course;
        List<Assignment> assignments = assignmentDAO.getAssignmentsFor(course);
        List<Student> students = studentDAO.getEnrolledStudents(course);
        teacherManageAssignmentsPanel.setStudents(students);
        teacherManageAssignmentsPanel.setAssignments(assignments);
    }

    @Override
    public void assignmentSelected(Assignment assignment) {
    	if(student == null || assignment == null) {
    		return;
    	}
    	studentAssignment = assignmentDAO.getStudentAssignment(student, assignment);
        teacherManageAssignmentsPanel.setDeadline(studentAssignment.getDeadline());
        teacherManageAssignmentsPanel.setLastUpdate(studentAssignment.getLastUpdate());
        teacherManageAssignmentsPanel.setGrade(studentAssignment.getGrade());
    }
    
    @Override
    public void studentSelected(Student student) {
        this.student = student;
		List<Assignment> assignments = assignmentDAO.getAssignmentsFor(course);
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
        assignmentDAO.save(studentAssignment);
    }

    @Override
	public void setTeacherManageAssignmentsPanel(TeacherManageAssignmentsPanel teacherManageAssignmentsPanel) {
		this.teacherManageAssignmentsPanel = teacherManageAssignmentsPanel;
	}

	@Override
	public void deleteStdent(Student selectedStudent) {
		studentDAO.removeFromCourse(selectedStudent, course);
		student = null;
		courseSelected(course);
	}

    
    
}
