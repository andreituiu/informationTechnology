package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminCreateCoursesController;
import com.controllers.admin.IAdminManageCoursesController;
import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.repository.CourseRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.TeacherRepository;
import com.views.admin.CreateCourses;

@Component
public class AdminCreateCoursesController implements IAdminCreateCoursesController {

	@Autowired
	private CreateCourses adminCreateCourses;

	@Autowired
	private CourseRepository coursesRepository;

	private Teacher teacherSelected;

	@Autowired
	private TeacherRepository teachersRepository;

	@Autowired
	private SpecializationRepository specializationRepository;
	private Specialization specializationSelected;

	@Autowired
	private IAdminManageCoursesController adminManageCoursesController;

	public AdminCreateCoursesController() {
		super();
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

		coursesRepository.save(course);
		adminManageCoursesController.viewCourses();
		;
	}

	public void openFrame() {
		adminCreateCourses.ereaseAll();
		adminCreateCourses.populateTeachers(teachersRepository.findAll());
		adminCreateCourses.populateSpecializations(specializationRepository.findAll());
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
