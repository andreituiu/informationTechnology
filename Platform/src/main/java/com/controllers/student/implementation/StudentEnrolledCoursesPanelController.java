package com.controllers.student.implementation;

import java.util.List;
import java.util.Set;

import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.dao.AssignmentDAO;
import com.model.dao.CourseDAO;
import com.views.student.StudentEnrolledCoursesPanel;

public class StudentEnrolledCoursesPanelController implements IStudentEnrolledCoursesPanelController {

	private StudentEnrolledCoursesPanel studentEnrolledCoursesPanel;
	private CourseDAO coursesDAO;
	private Student student;
    private AssignmentDAO assignmentDAO;
	
	

	public StudentEnrolledCoursesPanelController(CourseDAO coursesDAO, AssignmentDAO assignmentDAO, Student student) {
		super();
		this.coursesDAO = coursesDAO;
		this.student = student;
		this.assignmentDAO = assignmentDAO;
	}

	
	@Override
	public void setStudentEnrolledCoursesPanel(StudentEnrolledCoursesPanel studentEnrolledCoursesPanel) {
		this.studentEnrolledCoursesPanel = studentEnrolledCoursesPanel;
	}



	@Override
	public void update() {
		List<Course> courses = coursesDAO.getEnrolledCourses(student);
		studentEnrolledCoursesPanel.populateCourses(courses);
	}

	@Override
	public void courseSelected(Course course) {
		List<Assignment> courseAssignments = assignmentDAO.getAssignmentsFor(course);
		studentEnrolledCoursesPanel.populateAssignments(courseAssignments);
	}

	@Override
	public void assignmentSelected(Assignment assignment) {
		if (assignment == null) {
			return;
		}

		studentEnrolledCoursesPanel.setDeadline(assignment.getDeadline());
		studentEnrolledCoursesPanel.setLastUpload(assignment.getLastUpdate());
		studentEnrolledCoursesPanel.setGrade(assignment.getGrade());
	}

}
