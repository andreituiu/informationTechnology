package com.controllers.admin;

import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.views.admin.ModifyCourses;

public interface IAdminModifyCoursesController {

	void saveCourse();

	void selectSpecialization(Specialization selectedItem);

	void selectTeacher(Teacher selectedItem);

	void courseSelected(Course selectedCourse);

	void openFrame();

	void setAdminModifyCourses(ModifyCourses adminModifyCourses);

}
