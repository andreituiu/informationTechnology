package com.controllers.admin;

import com.model.Teacher;
import com.model.Specialization;
public interface IAdminCreateCoursesController {


	void saveCourse();

	void selectTeacher(Teacher teacher);

	void selectSpecialization(Specialization sepecialization);
	
	void openFrame();


	

}
