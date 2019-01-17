package com.controllers.student.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentFindCoursePannelController;
import com.model.Course;
import com.model.Student;
import com.model.dao.CourseDAO;
import com.model.dao.StudentDAO;
import com.model.repository.CourseRepository;
import com.model.repository.StudentRepository;
import com.views.student.StudentFindCoursePannel;

@Component
public class StudentFindCoursePannelController implements IStudentFindCoursePannelController {

	@Autowired
	private StudentFindCoursePannel studentFindCoursePannel;
	private Student student;
	private List<Course> notEnrolledCourses;
	
	@Autowired 
	private CourseRepository coursesRepository;

	@Autowired
	private StudentRepository studentRepository;

	

	public StudentFindCoursePannelController(Student student, CourseDAO coursesDAO, StudentDAO studentDAO) {
		super();
		this.student = student;
		this.coursesRepository = coursesDAO;
		this.studentRepository = studentDAO;
	}



	public StudentFindCoursePannelController() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public void setStudentFindCoursePannel(StudentFindCoursePannel studentFindCoursePannel) {
		this.studentFindCoursePannel = studentFindCoursePannel;
	}



	@Override
	public void update() {
		List<Course> pendingCourses = new ArrayList<>(student.getPendingCourses());
		List<Course> enrolledCourses = new ArrayList<>(student.getEnrolledCourses());
		List<Course> notEnrolledCourses = coursesRepository.findAll();
		notEnrolledCourses.removeAll(pendingCourses);
		notEnrolledCourses.removeAll(enrolledCourses);
		
		this.notEnrolledCourses = notEnrolledCourses;
		
		studentFindCoursePannel.populate(notEnrolledCourses, pendingCourses, enrolledCourses);
	}


	@Override
	public void searchCourse() {
		String searchedText = studentFindCoursePannel.getSearchedText();
	
		List<Course> pendingCourses = coursesRepository.getPendingCoursesContaining(student, searchedText);
		List<Course> enrolledCourses = coursesRepository.getEnrolledCoursesContaining(student, searchedText);
		List<Course> notEnrolledCourses = coursesRepository.getNotEnrolledCoursesContaining(student, searchedText);
		
		this.notEnrolledCourses = notEnrolledCourses;
		
		studentFindCoursePannel.populate(notEnrolledCourses, pendingCourses, enrolledCourses);
	}


	@Override
	public void sendPendingRequest(Course selectedCourse) {
		List<Course> studentNotEnrolledCourse = coursesRepository.findAll();
		studentNotEnrolledCourse.removeAll(student.getEnrolledCourses());
		studentNotEnrolledCourse.removeAll(student.getPendingCourses());
		if(studentNotEnrolledCourse.contains(selectedCourse)) {
			student.addPendingCourse(selectedCourse);
			selectedCourse.setPendingStudent(student);
			coursesRepository.save(selectedCourse);
			update();
		}
	}



	@Override
	public void setStudent(Student student) {
		this.student = student;
	}

}
