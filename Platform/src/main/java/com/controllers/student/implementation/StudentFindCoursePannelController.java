package com.controllers.student.implementation;

import java.util.List;

import com.controllers.student.IStudentFindCoursePannelController;
import com.model.Course;
import com.model.dao.CourseDAO;
import com.views.student.StudentFindCoursePannel;

public class StudentFindCoursePannelController implements IStudentFindCoursePannelController {

	private StudentFindCoursePannel studentFindCoursePannel;
	private CourseDAO coursesDAO;
	

	public StudentFindCoursePannelController(CourseDAO coursesDAO) {
		super();
		this.coursesDAO = coursesDAO;
	}


	@Override
	public void setStudentFindCoursePannel(StudentFindCoursePannel studentFindCoursePannel) {
		this.studentFindCoursePannel = studentFindCoursePannel;
	}



	@Override
	public void update() {
		List<Course> courses = coursesDAO.getAllCourses();
		studentFindCoursePannel.populate(courses);
	}


	@Override
	public void searchCourse() {
		String searchedText = studentFindCoursePannel.getSearchedText();
	
		List<Course> courses = coursesDAO.getAllCoursesContaining(searchedText);
		studentFindCoursePannel.populate(courses);
	}

}
