package com.controllers.teacher.implementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCreateAssignmentFrameController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.repository.CourseRepository;
import com.model.repository.StudentAssignmentRepository;
import com.views.teacher.TeacherManageAssignmentsPanel;

@Component
public class TeacherManageAssignmentsPanelController implements ITeacherManageAssignmentsPanelController {

	@Autowired
	private TeacherManageAssignmentsPanel teacherManageAssignmentsPanel;
	private Course course;

	@Autowired
	private StudentAssignmentRepository studentAssignmentRepository;

	@Autowired
	private ITeacherCreateAssignmentFrameController teacherCreateAssignmentFrameController;

	private StudentAssignment studentAssignment;
	private Student student;

	@Autowired
	private CourseRepository courseRepository;

	public TeacherManageAssignmentsPanelController() {
		super();
	}

	@Override
	public void courseSelected(Course course) {
		this.course = course;
		studentAssignment = null;
		List<Assignment> assignments = new ArrayList<>(course.getAssignments());
		List<Student> students = new ArrayList<>(course.getEnrolledStudents());
		teacherManageAssignmentsPanel.setStudents(students);
		teacherManageAssignmentsPanel.setAssignments(assignments);
	}

	@Override
	public void assignmentSelected(Assignment assignment) {
		if (student == null || assignment == null) {
			return;
		}
		studentAssignment = student.getStudentAssignmentFor(assignment);
		if (studentAssignment == null) {
			teacherManageAssignmentsPanel.ereaseFields();
			return;
		}

		teacherManageAssignmentsPanel.setDeadline(studentAssignment.getDeadline());
		teacherManageAssignmentsPanel.setLastUpdate(studentAssignment.getLastUpdate());
		teacherManageAssignmentsPanel.setGrade(studentAssignment.getGrade());
	}

	@Override
	public void studentSelected(Student student) {
		this.student = student;
	}

	@Override
	public void createAssignment() {
		teacherCreateAssignmentFrameController.setCourse(course);
		teacherCreateAssignmentFrameController.openFrame();
	}

	@Override
	public void saveGrade() {
		Double grade = teacherManageAssignmentsPanel.getGrade();
		if (studentAssignment == null) {
			return;
		}
		studentAssignment.setGrade(grade);
		studentAssignmentRepository.save(studentAssignment);
	}

	@Override
	public void setTeacherManageAssignmentsPanel(TeacherManageAssignmentsPanel teacherManageAssignmentsPanel) {
		this.teacherManageAssignmentsPanel = teacherManageAssignmentsPanel;
	}

	@Override
	public void deleteStdent(Student selectedStudent) {
		selectedStudent.getEnrolledCourses().remove(course);
		course.getEnrolledStudents().remove(selectedStudent);
		courseRepository.save(course);
		courseSelected(course);
	}

	@Override
	public void updateFields() {
		student = teacherManageAssignmentsPanel.getSelectedStudent();
		Assignment assignment = teacherManageAssignmentsPanel.getSelectedAssignment();

		if (student == null || assignment == null) {
			return;
		}
		studentAssignment = student.getStudentAssignmentFor(assignment);
		if (studentAssignment == null) {
			teacherManageAssignmentsPanel.ereaseFields();
			return;
		}
		teacherManageAssignmentsPanel.setDeadline(studentAssignment.getDeadline());
		teacherManageAssignmentsPanel.setLastUpdate(studentAssignment.getLastUpdate());
		teacherManageAssignmentsPanel.setGrade(studentAssignment.getGrade());
	}

	@Override
	public void downloadFile() {
		if (studentAssignment == null) {
			teacherManageAssignmentsPanel.showPopupInfo("No available file!");
			return;
		}
		String home = System.getProperty("user.home");
		File filePath = new File(home + "/Downloads/" + studentAssignment.getFileName());
		try {
			FileUtils.writeByteArrayToFile(filePath, studentAssignment.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		teacherManageAssignmentsPanel.showPopupInfo("File downloaded in :" + filePath.getAbsolutePath());
	}

}
