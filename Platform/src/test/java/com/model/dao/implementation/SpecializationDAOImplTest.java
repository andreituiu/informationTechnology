package com.model.dao.implementation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Course;
import com.model.Specialization;
import com.model.dao.SpecializationDAO;

public class SpecializationDAOImplTest extends UnitilsTestNG{

	private SpecializationDAO specializationDAO;
	private Utils utils;
	
	
	
	public SpecializationDAOImplTest() {
		super();
		utils = new Utils();
		specializationDAO = utils.specializationDAO;
	}

	@BeforeTest
	public void init() {
		utils.init();
	}
	
	@AfterTest
	public void destory() {
		utils.destroy();
	}

	@Test
	public void testGetAllSpecializations() {
		List<Specialization> specializations = specializationDAO.getAllSpecializations();
		
		Assert.assertFalse(specializations.isEmpty());
	}
	
	@Test
	public void testUpdateSpecializationName() {
		Specialization specialization = new Specialization();
		specialization.setName("newName");
		specializationDAO.updateSpecializationName(specialization, Utils.SPECIALIZATION_NAME);
		
		List<Specialization> specializations = specializationDAO.getAllSpecializations();
		
		boolean found = false;
		for(Specialization sp : specializations) {
			if(sp.getName().equals("newName")) {
				found = true;
			}
		}
		Assert.assertTrue(found);
		found = false;
		specialization.setName(Utils.SPECIALIZATION_NAME);
		specializationDAO.updateSpecializationName(specialization, "newName");		
		
		for(Specialization sp : specializations) {
			if(sp.getName().equals("newName")) {
				found = true;
			}
		}
		Assert.assertFalse(found);
	}
	
	@Test
	public void testGetSpecializationFor() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		Specialization specialization = specializationDAO.getSpecializationFor(course);
		Assert.assertEquals(specialization.getName(), Utils.SPECIALIZATION_NAME);
	}
}
