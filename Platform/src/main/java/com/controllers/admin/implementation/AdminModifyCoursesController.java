package com.controllers.admin.implementation;

import com.controllers.admin.IAdminModifyCoursesController;
import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.dao.CourseDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.TeacherDAO;
import com.views.admin.ModifyCourses;

public class AdminModifyCoursesController implements IAdminModifyCoursesController {


	private Course selectedCourse;
	private CourseDAO courseDAO;
	
	private Teacher teacherSelected;
	private TeacherDAO teacherDAO;
	
	private Specialization specializationSelected;
	private SpecializationDAO specializationDAO;
	
	private ModifyCourses adminModifyCourses;
	
	
	
	public AdminModifyCoursesController(CourseDAO courseDAO, TeacherDAO teacherDAO,
			SpecializationDAO specializationDAO) {
		super();
		this.courseDAO = courseDAO;
		this.teacherDAO = teacherDAO;
		this.specializationDAO = specializationDAO;
	}
	
	
	@Override
	public void setAdminModifyCourses(ModifyCourses adminModifyCourses) {
		this.adminModifyCourses = adminModifyCourses;
	}



	@Override
	public void openFrame() {
		adminModifyCourses.ereaseAll();
		adminModifyCourses.populateTeachers(teacherDAO.getAllTeachers());
		adminModifyCourses.populateSpecializations(specializationDAO.getAllSpecializations());
		itemsForSelectedCourse();
		adminModifyCourses.setVisible(true);
		
		
	}

	@Override
	public void courseSelected(Course course) {
		selectedCourse = course;
	}

	@Override
	public void saveCourse() {
		String oldCourseName = selectedCourse.getName();
		selectedCourse.setName(adminModifyCourses.getName());
		selectedCourse.setYear(adminModifyCourses.getYear());
		selectedCourse.setSemester(adminModifyCourses.getSemester());
		selectedCourse.setTeacher(teacherSelected);
		selectedCourse.setSpecialization(specializationSelected);
		
		courseDAO.updateCourse(selectedCourse, oldCourseName);
	}

	@Override
	public void selectSpecialization(Specialization specialization) {
	
		specializationSelected = specialization;
	}
	

	@Override
	public void selectTeacher(Teacher teacher) {
		 teacherSelected = teacher; 
		
	}
	private void itemsForSelectedCourse() {
		adminModifyCourses.setName(selectedCourse.getName());
		adminModifyCourses.setYear(selectedCourse.getYear());
		adminModifyCourses.setSemester(selectedCourse.getSemester());
		adminModifyCourses.setTeacher(selectedCourse.getTeacher());
		adminModifyCourses.setSpecialization(selectedCourse.getSpecialization());
	}
	


}
