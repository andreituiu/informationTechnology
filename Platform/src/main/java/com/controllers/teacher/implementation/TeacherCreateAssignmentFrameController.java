package com.controllers.teacher.implementation;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.model.Assignment;
import com.model.Course;
import com.model.dao.AssignmentDAO;
import com.views.teacher.TeacherCreateAssignmentFrame;

public class TeacherCreateAssignmentFrameController implements ITeacherCreateAssignmentFrameController {

	private TeacherCreateAssignmentFrame teacherCreateAssignmentFrame;
	private Course course;
	private AssignmentDAO assignmentDAO;
	
	

	public TeacherCreateAssignmentFrameController(AssignmentDAO assignmentDAO) {
		super();
		this.assignmentDAO = assignmentDAO;
	}

	@Override
	public void openFrame() {
		teacherCreateAssignmentFrame.setVisible(true);
	}

	@Override
	public void setCourse(Course course) {
		this.course = course;

	}

	@Override
	public void save() {
		Assignment assignment = new Assignment();
		assignment.setName(teacherCreateAssignmentFrame.getName());
		assignment.setDeadline(teacherCreateAssignmentFrame.getDeadline());
		assignment.setCourseName(course.getName());
		assignmentDAO.save(assignment);
		
	}

	@Override
	public void setTeacherCreateAssignmentFrame(TeacherCreateAssignmentFrame teacherCreateAssignmentFrame) {
		this.teacherCreateAssignmentFrame = teacherCreateAssignmentFrame;
	}
	
	

}
