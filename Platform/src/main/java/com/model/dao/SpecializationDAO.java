package com.model.dao;

import java.util.List;

import com.model.Specialization;

public interface SpecializationDAO {
	 List<Specialization> getAllSpecializations();

	void saveNewSpecialization(Specialization specialization);


}