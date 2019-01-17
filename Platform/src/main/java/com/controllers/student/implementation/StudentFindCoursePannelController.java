package com.controllers.student.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.student.IStudentFindCoursePannelController;
import com.model.Course;
import com.model.Student;
import com.model.repository.CourseRepository;
import com.views.student.StudentFindCoursePannel;

@Component
public class StudentFindCoursePannelController implements IStudentFindCoursePannelController {

	@Autowired
	private StudentFindCoursePannel studentFindCoursePannel;
	private Student student;

	@Autowired
	private CourseRepository coursesRepository;

	public StudentFindCoursePannelController() {
		super();
	}

	@Override
	public void setStudentFindCoursePannel(StudentFindCoursePannel studentFindCoursePannel) {
		this.studentFindCoursePannel = studentFindCoursePannel;
	}

	@Override
	public void update() {
		List<Course> pendingCourses = new ArrayList<>(student.getPendingCourses());
		List<Course> enrolledCourses = new ArrayList<>(student.getEnrolledCourses());
		List<Course> notEnrolledCourses = coursesRepository.findAll();
		notEnrolledCourses.removeAll(pendingCourses);
		notEnrolledCourses.removeAll(enrolledCourses);

		studentFindCoursePannel.populate(notEnrolledCourses, pendingCourses, enrolledCourses);
	}

	@Override
	public void searchCourse() {
		String searchedText = studentFindCoursePannel.getSearchedText();
		List<Course> courses = coursesRepository
				.findByNameContainingOrTeacherNameContainingOrTeacherSurnameContainingOrSpecializationNameContaining(
						searchedText, searchedText, searchedText, searchedText);

		List<Course> pendingCourses = new ArrayList<>();
		List<Course> enrolledCourses = new ArrayList<>();
		List<Course> notEnrolledCourses = new ArrayList<>();

		Set<Course> studentAllPendingCourses = student.getPendingCourses();
		Set<Course> studentAllEnrolledCourses = student.getEnrolledCourses();
		for (Course course : courses) {
			if (studentAllPendingCourses.contains(course)) {
				pendingCourses.add(course);
			} else  if (studentAllEnrolledCourses.contains(course)) {
					enrolledCourses.add(course);
			} else {
					notEnrolledCourses.add(course);
			}
		}

		studentFindCoursePannel.populate(notEnrolledCourses, pendingCourses, enrolledCourses);
	}

	@Override
	public void sendPendingRequest(Course selectedCourse) {
		List<Course> studentNotEnrolledCourse = coursesRepository.findAll();
		studentNotEnrolledCourse.removeAll(student.getEnrolledCourses());
		studentNotEnrolledCourse.removeAll(student.getPendingCourses());
		if (studentNotEnrolledCourse.contains(selectedCourse)) {
			student.addPendingCourse(selectedCourse);
			selectedCourse.setPendingStudent(student);
			coursesRepository.save(selectedCourse);
			update();
		}
	}

	@Override
	public void setStudent(Student student) {
		this.student = student;
	}

}
