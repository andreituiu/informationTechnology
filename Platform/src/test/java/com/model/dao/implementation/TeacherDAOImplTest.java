package com.model.dao.implementation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Course;
import com.model.Teacher;
import com.model.User;
import com.model.dao.TeacherDAO;

public class TeacherDAOImplTest extends UnitilsTestNG{

	private TeacherDAO teacherDAO;
	private Utils utils;

	
	
	public TeacherDAOImplTest() {
		super();
		utils = new Utils();
		teacherDAO = utils.teacherDAO;
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
	public void testGetTeacher() {
		Teacher teacher = teacherDAO.getTeacher(Utils.TEACHER_CNP);
	
		Assert.assertNotNull(teacher);
	}
	
	@Test 
	public void testGetAllteachers() {
		List<Teacher> teachers = teacherDAO.getAllTeachers();
	
		Assert.assertFalse(teachers.isEmpty());
	}
	
	@Test
	public void testGetTeacherFor() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		Teacher teacher = teacherDAO.getTeacherFor(course);
		
		Assert.assertNotNull(teacher);
		Assert.assertEquals(teacher.getCnp(), Utils.TEACHER_CNP);
	}
	
	@Test
	public void testUpdate() {
		Teacher teacher = teacherDAO.getTeacher(Utils.TEACHER_CNP);
		teacher.setName("newName");
		teacherDAO.update(teacher);
		teacher = teacherDAO.getTeacher(Utils.TEACHER_CNP);
		Assert.assertEquals(teacher.getName(), "newName");
	}
	
	@Test
	public void testDelete() {
		User user = new User();
		user.setCnp(Utils.TEACHER_CNP);
		teacherDAO.deleteUser(user);
		Teacher teacher = teacherDAO.getTeacher(Utils.TEACHER_CNP);
		Assert.assertNull(teacher);
	}
}
