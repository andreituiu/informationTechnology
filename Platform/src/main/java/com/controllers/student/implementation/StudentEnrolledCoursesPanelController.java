package com.controllers.student.implementation;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentChooseFileUploadAssignmentController;
import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.repository.StudentAssignmentRepository;
import com.views.student.StudentEnrolledCoursesPanel;

@Component
public class StudentEnrolledCoursesPanelController implements IStudentEnrolledCoursesPanelController {

	@Autowired
	private StudentEnrolledCoursesPanel studentEnrolledCoursesPanel;
	private Student student;
	private Assignment assignment;

	@Autowired
	private IStudentChooseFileUploadAssignmentController studentChooseFileUploadAssginmentController;
	private File selectedUploadFile;

	@Autowired
	private StudentAssignmentRepository studentAssignmentRepository;
	private StudentAssignment studentAssignment;

	public StudentEnrolledCoursesPanelController() {
		super();
	}

	@Override
	public void setStudentEnrolledCoursesPanel(StudentEnrolledCoursesPanel studentEnrolledCoursesPanel) {
		this.studentEnrolledCoursesPanel = studentEnrolledCoursesPanel;
	}

	@Override
	public void update() {
		List<Course> courses = new ArrayList<>(student.getEnrolledCourses());
		studentEnrolledCoursesPanel.populateCourses(courses);
	}

	@Override
	public void courseSelected(Course course) {
		List<Assignment> courseAssignments = new ArrayList<>(course.getAssignments());
		studentEnrolledCoursesPanel.populateAssignments(courseAssignments);
	}

	@Override
	public void assignmentSelected(Assignment assignment) {
		if (assignment == null) {
			return;
		}
		this.assignment = assignment;
		studentAssignment = student.getStudentAssignmentFor(assignment);

		if (studentAssignment == null) {
			studentAssignment = new StudentAssignment();
			studentAssignment.setAssignment(assignment);
			studentAssignment.setStudent(student);
		}
		updateStudentAssignmentsDetails();
	}

	@Override
	public void updateStudentAssignmentsDetails() {
		if (studentAssignment == null) {
			return;
		}
		studentEnrolledCoursesPanel.setDeadline(studentAssignment.getDeadline());
		studentEnrolledCoursesPanel.setLastUpload(studentAssignment.getLastUpdate());
		studentEnrolledCoursesPanel.setGrade(studentAssignment.getGrade());
		studentEnrolledCoursesPanel.setFileName(studentAssignment.getFileName());
	}

	@Override
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public void chooseFileUpload() {
		studentChooseFileUploadAssginmentController.openFrame();
	}

	@Override
	public void setSelectedUploadFile(File selectedUploadFile) {
		this.selectedUploadFile = selectedUploadFile;
	}

	@Override
	public void save() {
		if (studentAssignment == null) {
			studentAssignment = new StudentAssignment();
			studentAssignment.setAssignment(assignment);
			studentAssignment.setStudent(student);
		}
		Date currentDate = new Date();
		studentAssignment.setLastUpdate(currentDate);
		studentAssignment.setFile(selectedUploadFile);
		studentAssignmentRepository.save(studentAssignment);
		updateStudentAssignmentsDetails();

	}

}
