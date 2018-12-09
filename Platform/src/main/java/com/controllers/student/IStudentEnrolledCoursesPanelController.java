package com.controllers.student;

import com.model.Assignment;
import com.model.Course;
import com.model.StudentAssignment;
import com.views.student.StudentEnrolledCoursesPanel;

public interface IStudentEnrolledCoursesPanelController {

	void update();

	void courseSelected(Course selectedValue);

	void assignmentSelected(StudentAssignment studentAssignment);

	void setStudentEnrolledCoursesPanel(StudentEnrolledCoursesPanel studentEnrolledCoursesPanel);

}
