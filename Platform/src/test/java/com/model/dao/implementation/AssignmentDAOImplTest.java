package com.model.dao.implementation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Assignment;
import com.model.Course;
import com.model.Specialization;
import com.model.Student;
import com.model.StudentAssignment;
import com.model.Teacher;
import com.model.dao.AssignmentDAO;
import com.model.dao.CourseDAO;

public class AssignmentDAOImplTest extends UnitilsTestNG {

	private AssignmentDAO assignmentDAO;
	private Utils utils;

	
	
	public AssignmentDAOImplTest() {
		super();
		utils = new Utils();
		assignmentDAO = utils.assignmentDAO;
		
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
	public void testGetAssignmentsForCourse() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		
		List<Assignment> assignments = assignmentDAO.getAssignmentsFor(course);
	
		Assert.assertFalse(assignments.isEmpty());
	}
	
	
}
