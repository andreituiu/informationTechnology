package com.controllers.student.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentEnrolledCoursesPanelController;
import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.dao.AssignmentDAO;
import com.model.dao.CourseDAO;
import com.model.repository.AssignmentRepository;
import com.model.repository.CourseRepository;
import com.views.student.StudentEnrolledCoursesPanel;

@Component
public class StudentEnrolledCoursesPanelController implements IStudentEnrolledCoursesPanelController {

	@Autowired
	private StudentEnrolledCoursesPanel studentEnrolledCoursesPanel;
	private Student student;

	@Autowired
	private CourseRepository coursesRepository;
    
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	

	public StudentEnrolledCoursesPanelController(CourseDAO coursesDAO, AssignmentDAO assignmentDAO, Student student) {
		super();
		this.coursesRepository = coursesDAO;
		this.student = student;
		this.assignmentRepository = assignmentDAO;
	}

	
	
	public StudentEnrolledCoursesPanelController() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public void setStudentEnrolledCoursesPanel(StudentEnrolledCoursesPanel studentEnrolledCoursesPanel) {
		this.studentEnrolledCoursesPanel = studentEnrolledCoursesPanel;
	}



	@Override
	public void update() {
		List<Course> courses = new ArrayList<>( student.getEnrolledCourses());
		studentEnrolledCoursesPanel.populateCourses(courses);
	}

	@Override
	public void courseSelected(Course course) {
		List<Assignment> courseAssignments = assignmentRepository.getAssignmentsFor(course);
		studentEnrolledCoursesPanel.populateAssignments(courseAssignments);
	}

	@Override
	public void assignmentSelected(Assignment assignment) {
		if (assignment == null) {
			return;
		}

		studentEnrolledCoursesPanel.setDeadline(assignment.getDeadline());
//		studentEnrolledCoursesPanel.setLastUpload(assignment.getLastUpdate());
//		studentEnrolledCoursesPanel.setGrade(assignment.getGrade());
	}


	@Override
	public void setStudent(Student student) {
		this.student = student;
	}

}
