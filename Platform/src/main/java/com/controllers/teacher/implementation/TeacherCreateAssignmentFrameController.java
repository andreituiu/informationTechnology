package com.controllers.teacher.implementation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.model.Assignment;
import com.model.Course;
import com.model.dao.AssignmentDAO;
import com.model.repository.AssignmentRepository;
import com.views.teacher.TeacherCreateAssignmentFrame;

@Component
public class TeacherCreateAssignmentFrameController implements ITeacherCreateAssignmentFrameController {

	@Autowired
	private TeacherCreateAssignmentFrame teacherCreateAssignmentFrame;
	private Course course;
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	

	public TeacherCreateAssignmentFrameController(AssignmentDAO assignmentDAO) {
		super();
		this.assignmentRepository = assignmentDAO;
	}

	
	
	public TeacherCreateAssignmentFrameController() {
		super();
		// TODO Auto-generated constructor stub
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
		Date deadline = teacherCreateAssignmentFrame.getDeadline();
		if(deadline == null) {
			return ;
		}
		assignment.setDeadline(deadline);
		assignment.setCourse(course);
		assignmentRepository.save(assignment);
		
	}

	@Override
	public void setTeacherCreateAssignmentFrame(TeacherCreateAssignmentFrame teacherCreateAssignmentFrame) {
		this.teacherCreateAssignmentFrame = teacherCreateAssignmentFrame;
	}
	
	

}
