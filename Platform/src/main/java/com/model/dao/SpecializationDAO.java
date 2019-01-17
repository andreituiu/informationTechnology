package com.model.dao;

import java.util.List;

import com.model.Specialization;
import com.model.User;

public interface SpecializationDAO extends  BaseDAO<Specialization, Integer>{

	List<Specialization> findAll();
//	 List<Specialization> getAllSpecializations();
//
//	void saveNewSpecialization(Specialization specialization);
//
//	Specialization getSpecializationFor(Course selectedCourse);
//
//	void updateSpecializationName(Specialization specializationSelected);


}