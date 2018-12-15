package com.controllers.teacher.implementation;

import java.util.List;

import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Course;
import com.model.Student;
import com.model.dao.StudentDAO;
import com.views.teacher.TeacherManageStudentsPanel;

public class TeacherManageStudentsPanelController implements ITeacherManageStudentsPanelController {

	private TeacherManageStudentsPanel teacherManageStudentsPanel;
	private StudentDAO studentDAO;
	private Course course;

	public TeacherManageStudentsPanelController(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	@Override
	public void courseSelected(Course course) {

		this.course = course;

		update();
	}

	private void update() {
		List<Student> waitingStudents = studentDAO.getWaitingStudents(course);
		List<Student> enrolledStudents = studentDAO.getEnrolledStudents(course);
		teacherManageStudentsPanel.populateWaitingStudents(waitingStudents);
		teacherManageStudentsPanel.populateEnrolledStudents(enrolledStudents);
	}

	@Override
	public void acceptStudent(Student selectedStudent) {
		studentDAO.enrolleToCourse(selectedStudent, course);
		update();
	}

	@Override
	public void removeStudent(Student selectedStudent) {
		studentDAO.removeFromCourse(selectedStudent, course);
		update();
	}

	@Override
	public void setTeacherManageStudentsPanel(TeacherManageStudentsPanel teacherManageStudentsPanel) {
		this.teacherManageStudentsPanel = teacherManageStudentsPanel;
	}

}
