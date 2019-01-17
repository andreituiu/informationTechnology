package com.controllers.student;

import java.io.File;

import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.views.student.StudentEnrolledCoursesPanel;

public interface IStudentEnrolledCoursesPanelController {

	void update();

	void courseSelected(Course selectedValue);

	void assignmentSelected(Assignment studentAssignment);

	void setStudentEnrolledCoursesPanel(StudentEnrolledCoursesPanel studentEnrolledCoursesPanel);

	void setStudent(Student student);

	void chooseFileUpload();

	void setSelectedUploadFile(File selectedFile);

	void save();

	void updateStudentAssignmentsDetails();

}
