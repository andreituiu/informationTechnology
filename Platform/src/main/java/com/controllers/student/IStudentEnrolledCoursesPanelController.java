package com.controllers.student;

import com.model.Assignment;
import com.model.Course;
import com.views.student.StudentEnrolledCoursesPanel;

public interface IStudentEnrolledCoursesPanelController {

	void update();

	void courseSelected(Course selectedValue);

	void assignmentSelected(Assignment studentAssignment);

	void setStudentEnrolledCoursesPanel(StudentEnrolledCoursesPanel studentEnrolledCoursesPanel);

}
