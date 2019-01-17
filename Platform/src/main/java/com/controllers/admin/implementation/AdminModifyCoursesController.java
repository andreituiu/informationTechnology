package com.controllers.admin.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.admin.IAdminManageCoursesController;
import com.controllers.admin.IAdminModifyCoursesController;
import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.repository.CourseRepository;
import com.model.repository.SpecializationRepository;
import com.model.repository.TeacherRepository;
import com.views.admin.ModifyCourses;

@Component
public class AdminModifyCoursesController implements IAdminModifyCoursesController {

	private Course selectedCourse;

	@Autowired
	private CourseRepository courseRepository;

	private Teacher teacherSelected;

	@Autowired
	private TeacherRepository teacherRepository;

	private Specialization specializationSelected;

	@Autowired
	private SpecializationRepository specializationRepository;

	@Autowired
	private ModifyCourses adminModifyCourses;

	@Autowired
	private IAdminManageCoursesController adminManageCoursesController;

	public AdminModifyCoursesController() {
		super();
	}

	@Override
	public void setAdminModifyCourses(ModifyCourses adminModifyCourses) {
		this.adminModifyCourses = adminModifyCourses;
	}

	@Override
	public void openFrame() {
		adminModifyCourses.ereaseAll();
		adminModifyCourses.populateTeachers(teacherRepository.findAll());
		adminModifyCourses.populateSpecializations(specializationRepository.findAll());
		itemsForSelectedCourse();
		adminModifyCourses.setVisible(true);

	}

	@Override
	public void courseSelected(Course course) {
		selectedCourse = course;
	}

	@Override
	public void saveCourse() {

		selectedCourse.setName(adminModifyCourses.getName());
		selectedCourse.setYear(adminModifyCourses.getYear());
		selectedCourse.setSemester(adminModifyCourses.getSemester());
		selectedCourse.setTeacher(teacherSelected);
		selectedCourse.setSpecialization(specializationSelected);

		courseRepository.save(selectedCourse);
		
		adminManageCoursesController.viewCourses();
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
