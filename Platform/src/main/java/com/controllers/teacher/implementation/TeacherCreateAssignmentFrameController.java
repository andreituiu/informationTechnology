package com.controllers.teacher.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.repository.AssignmentRepository;
import com.views.teacher.TeacherCreateAssignmentFrame;

@Component
public class TeacherCreateAssignmentFrameController implements ITeacherCreateAssignmentFrameController {

	@Autowired
	private TeacherCreateAssignmentFrame teacherCreateAssignmentFrame;
	private Course course;

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelController;

	public TeacherCreateAssignmentFrameController() {
		super();
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
		String deadlineString = teacherCreateAssignmentFrame.getDeadline();
		Date deadline = null;
		try {
			deadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadlineString);
		} catch (ParseException e) {
		}
		if(deadline == null) {
			teacherCreateAssignmentFrame.showPopup("Invalid date format. Should be dd/MM/yyyy");
			return;
		}
		assignment.setDeadline(deadline);
		assignment.setCourse(course);
		assignmentRepository.save(assignment);
		course.getAssignments().add(assignment);
		teacherManageAssignmentsPanelController.courseSelected(course);
	}

	@Override
	public void setTeacherCreateAssignmentFrame(TeacherCreateAssignmentFrame teacherCreateAssignmentFrame) {
		this.teacherCreateAssignmentFrame = teacherCreateAssignmentFrame;
	}

}
