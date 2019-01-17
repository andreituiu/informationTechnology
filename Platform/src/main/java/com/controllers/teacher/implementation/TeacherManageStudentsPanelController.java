package com.controllers.teacher.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Course;
import com.model.Student;
import com.model.repository.CourseRepository;
import com.views.teacher.TeacherManageStudentsPanel;

@Component
public class TeacherManageStudentsPanelController implements ITeacherManageStudentsPanelController {

	@Autowired
	private TeacherManageStudentsPanel teacherManageStudentsPanel;
	private Course course;

	@Autowired
	private CourseRepository courseRepository;

	public TeacherManageStudentsPanelController() {
		super();
	}

	@Override
	public void courseSelected(Course course) {
		this.course = course;
		update();
	}

	@Override
	public void acceptStudent(Student selectedStudent) {
		selectedStudent.getPendingCourses().remove(course);
		selectedStudent.getEnrolledCourses().add(course);
		course.getPendingStudents().remove(selectedStudent);
		course.getEnrolledStudents().add(selectedStudent);
		courseRepository.save(course);
		update();
	}

	@Override
	public void removeStudent(Student selectedStudent) {
		selectedStudent.getEnrolledCourses().remove(course);
		course.getEnrolledStudents().remove(selectedStudent);
		courseRepository.save(course);
		update();
	}

	private void update() {
		List<Student> waitingStudents = new ArrayList<>(course.getPendingStudents());
		List<Student> enrolledStudents = new ArrayList<>(course.getEnrolledStudents());
		teacherManageStudentsPanel.populateWaitingStudents(waitingStudents);
		teacherManageStudentsPanel.populateEnrolledStudents(enrolledStudents);
	}

	@Override
	public void setTeacherManageStudentsPanel(TeacherManageStudentsPanel teacherManageStudentsPanel) {
		this.teacherManageStudentsPanel = teacherManageStudentsPanel;
	}

}
