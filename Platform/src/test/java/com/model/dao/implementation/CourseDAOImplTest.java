package com.model.dao.implementation;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.dao.CourseDAO;
import com.model.dao.SpecializationDAO;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;

public class CourseDAOImplTest extends UnitilsTestNG{

	private CourseDAO courseDAO;
	private Utils utils;

	
	
	public CourseDAOImplTest() {
		super();
		utils = new Utils();
		courseDAO = utils.courseDAO;
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
	public void testUpdateCourse() {
		String newName = "newCourseName";
		utils.course.setName(newName);
		courseDAO.updateCourse(utils.course, Utils.COURSE_NAME);
		
		Assert.assertTrue(courseDAO.getAllCoursesContaining(newName).size() > 0);
		utils.course.setName(Utils.COURSE_NAME);
		courseDAO.updateCourse(utils.course, newName);
	
	}
	
	@Test
	public void testGetAllCourses() {
		List<Course> courses = courseDAO.getAllCourses();
	
		Assert.assertTrue(courses.size() >= 1);
	}
	
	@Test 
	public void testGetEnrolledCourses() {
		List<Course> courses = courseDAO.getEnrolledCourses(utils.enrolledStudent);

		Assert.assertFalse(courses.isEmpty());
	}
	
	@Test
	public void testGetAllCoursesContaining() {
		List<Course> courses = courseDAO.getAllCoursesContaining(Utils.COURSE_NAME);
		
		Assert.assertFalse(courses.isEmpty());
	}
	
	@Test
	public void testGetCoursesForTeacher() {
		List<Course> courses = courseDAO.getCoursesForTeacher(utils.teacher);
		Assert.assertFalse(courses.isEmpty());
	}
	
	@Test 
	public void testGetNotEnrolledCourses() {
		List<Course> allCourses = courseDAO.getAllCourses();
		List<Course> courses = courseDAO.getNotEnrolledCourses(utils.student);

		Assert.assertEquals(allCourses.size(), courses.isEmpty());
	}
	
	@Test
	public void testGetPendingCourses() {
		List<Course> courses = courseDAO.getPendingCourses(utils.pendingStudent);

		Assert.assertFalse(courses.isEmpty());

	}

	@Test
	public void testGetPendingCoursesContains() {
		List<Course> courses = courseDAO.getPendingCoursesContaining(utils.pendingStudent, "12312sdoijfj23412");

		Assert.assertTrue(courses.isEmpty());

		courses = courseDAO.getPendingCoursesContaining(utils.pendingStudent, Utils.COURSE_NAME);
	
		Assert.assertFalse(courses.isEmpty());
	}


	@Test
	public void testGetEnrolledCoursesContains() {
		List<Course> courses = courseDAO.getEnrolledCoursesContaining(utils.enrolledStudent, "12312sdoijfj23412");

		Assert.assertTrue(courses.isEmpty());

		courses = courseDAO.getEnrolledCoursesContaining(utils.enrolledStudent, Utils.COURSE_NAME);
	
		Assert.assertFalse(courses.isEmpty());
	}

	@Test
	public void testGetNotEnrolledCoursesContains() {
		List<Course> courses = courseDAO.getNotEnrolledCoursesContaining(utils.student, "12312sdoijfj23412");

		Assert.assertTrue(courses.isEmpty());

		courses = courseDAO.getNotEnrolledCoursesContaining(utils.student, Utils.COURSE_NAME);
	
		Assert.assertFalse(courses.isEmpty());
	}
}
