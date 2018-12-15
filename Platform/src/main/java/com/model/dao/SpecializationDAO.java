package com.model.dao;

import java.util.List;

import com.model.Course;
import com.model.Specialization;

public interface SpecializationDAO {
	 List<Specialization> getAllSpecializations();

	void saveNewSpecialization(Specialization specialization);

	Specialization getSpecializationFor(Course selectedCourse);

	void updateSpecializationName(Specialization specializationSelected, String oldName);


}