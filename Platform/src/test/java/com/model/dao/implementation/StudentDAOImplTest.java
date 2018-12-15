package com.model.dao.implementation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;

import com.model.Course;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.model.dao.StudentDAO;

public class StudentDAOImplTest extends UnitilsTestNG {

	private StudentDAO studentDAO;
	private Utils utils;
	
	
	
	public StudentDAOImplTest() {
		super();
		utils = new Utils();
		studentDAO = utils.studentDAO;
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
	public void testGetStudent() {
		Student student = studentDAO.getStudent(Utils.STUDENT_CNP);

		Assert.assertNotNull(student);
	}

	@Test
	public void testGetWaitingStudents() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		List<Student> students = studentDAO.getWaitingStudents(course);

		Assert.assertFalse(students.isEmpty());
	}

	@Test
	public void testGetEnrolledStudents() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		List<Student> students = studentDAO.getEnrolledStudents(course);

		Assert.assertFalse(students.isEmpty());
	}

	@Test
	public void testUpdate() {
		Student student = studentDAO.getStudent(Utils.STUDENT_CNP);
		student.setName("newName");
		studentDAO.update(student);
		student = studentDAO.getStudent(Utils.STUDENT_CNP);
		Assert.assertEquals(student.getName(), "newName");
	}

	@Test 
	public void testRemoveFromCourse() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		List<Student> initialStudents = studentDAO.getEnrolledStudents(course);

		Student enrolledStudent = studentDAO.getStudent(Utils.STUDENT_CNP_ENROLLED);
		studentDAO.removeFromCourse(enrolledStudent , course);
		List<Student> finalStudents = studentDAO.getEnrolledStudents(course);
		
		Assert.assertEquals(initialStudents.size(), finalStudents.size() + 1);
	}
	
	@Test 
	public void testPendingStudent() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		List<Student> initialStudents = studentDAO.getWaitingStudents(course);

		Student student = studentDAO.getStudent(Utils.STUDENT_CNP);
		studentDAO.removeFromCourse(student , course);
		List<Student> finalStudents = studentDAO.getWaitingStudents(course);
		
		Assert.assertEquals(initialStudents.size(), finalStudents.size() - 1);
	}
	
	@Test 
	public void testEnrolledStudent() {
		Course course = new Course();
		course.setName(Utils.COURSE_NAME);
		List<Student> initialStudents = studentDAO.getEnrolledStudents(course);

		Student pendingStudent = studentDAO.getStudent(Utils.STUDENT_CNP_PENDING);
		studentDAO.removeFromCourse(pendingStudent , course);
		List<Student> finalStudents = studentDAO.getEnrolledStudents(course);
		
		Assert.assertEquals(initialStudents.size(), finalStudents.size() - 1);
	}
	
	@Test
	public void testDelete() {
		User user = new User();
		user.setCnp(Utils.STUDENT_CNP);
		studentDAO.deleteUser(user);
		Student student = studentDAO.getStudent(Utils.STUDENT_CNP);
		Assert.assertNull(student);
	}

}
