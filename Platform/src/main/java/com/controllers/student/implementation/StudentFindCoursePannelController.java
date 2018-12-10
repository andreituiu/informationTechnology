package com.controllers.student.implementation;

import java.util.List;

import com.controllers.student.IStudentFindCoursePannelController;
import com.model.Course;
import com.model.Student;
import com.model.dao.CourseDAO;
import com.model.dao.StudentDAO;
import com.views.student.StudentFindCoursePannel;

public class StudentFindCoursePannelController implements IStudentFindCoursePannelController {

	private StudentFindCoursePannel studentFindCoursePannel;
	private CourseDAO coursesDAO;
	private Student student;
	private StudentDAO studentDAO;
	private List<Course> notEnrolledCourses;
	

	

	public StudentFindCoursePannelController(Student student, CourseDAO coursesDAO, StudentDAO studentDAO) {
		super();
		this.student = student;
		this.coursesDAO = coursesDAO;
		this.studentDAO = studentDAO;
	}



	@Override
	public void setStudentFindCoursePannel(StudentFindCoursePannel studentFindCoursePannel) {
		this.studentFindCoursePannel = studentFindCoursePannel;
	}



	@Override
	public void update() {
		List<Course> pendingCourses = coursesDAO.getPendingCourses(student);
		List<Course> enrolledCourses = coursesDAO.getEnrolledCourses(student);
		List<Course> notEnrolledCourses = coursesDAO.getNotEnrolledCourses(student);
		
		this.notEnrolledCourses = notEnrolledCourses;
		
		studentFindCoursePannel.populate(notEnrolledCourses, pendingCourses, enrolledCourses);
	}


	@Override
	public void searchCourse() {
		String searchedText = studentFindCoursePannel.getSearchedText();
	
		List<Course> pendingCourses = coursesDAO.getPendingCoursesContaining(student, searchedText);
		List<Course> enrolledCourses = coursesDAO.getEnrolledCoursesContaining(student, searchedText);
		List<Course> notEnrolledCourses = coursesDAO.getNotEnrolledCoursesContaining(student, searchedText);
		
		this.notEnrolledCourses = notEnrolledCourses;
		
		studentFindCoursePannel.populate(notEnrolledCourses, pendingCourses, enrolledCourses);
	}


	@Override
	public void sendPendingRequest(Course selectedCourse) {
		if(notEnrolledCourses.contains(selectedCourse)) {
			studentDAO.pendingStudent(student, selectedCourse);
			update();
		}
	}

}
