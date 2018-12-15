package com.controllers.admin.implementation;

import com.controllers.admin.IAdminCreateCoursesController;
import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.dao.CourseDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.TeacherDAO;
import com.views.admin.CreateCourses;

public class AdminCreateCoursesController  implements IAdminCreateCoursesController {

	private CreateCourses adminCreateCourses;
	private CourseDAO coursesDAO;
	
	private Teacher teacherSelected;
	private TeacherDAO teachersDAO;
	
	private SpecializationDAO specializationDAO;
	private Specialization specializationSelected;

	

	public AdminCreateCoursesController(CourseDAO coursesDAO, TeacherDAO teachersDAO,
			SpecializationDAO specializationDAO) {
		super();
		this.coursesDAO = coursesDAO;
		this.teachersDAO = teachersDAO;
		this.specializationDAO = specializationDAO;
	}
	
	

	@Override
	public void setAdminCreateCourses(CreateCourses adminCreateCourses) {
		this.adminCreateCourses = adminCreateCourses;
	}




	@Override
	public void saveCourse() {

		 Course course = new Course();
		 course.setName(adminCreateCourses.getCourseName());
		 course.setYear(adminCreateCourses.getYear());
		 course.setSemester(adminCreateCourses.getSemester());
		 course.setTeacher(teacherSelected);
		 course.setSpecialization(specializationSelected);
		 
		 coursesDAO.saveNewCourse(course);
		
	}


	public void openFrame() {
		adminCreateCourses.ereaseAll();
		adminCreateCourses.populateTeachers(teachersDAO.getAllTeachers());
		adminCreateCourses.populateSpecializations(specializationDAO.getAllSpecializations());
		adminCreateCourses.setVisible(true);
		
	}


	@Override
	public void selectSpecialization(Specialization specialization) {
	
		specializationSelected = specialization;
	}
	

	@Override
	public void selectTeacher(Teacher teacher) {
		 teacherSelected = teacher;
		
	}


	

}

	






