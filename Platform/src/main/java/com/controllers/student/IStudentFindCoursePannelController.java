package com.controllers.student;

import com.model.Course;
import com.views.student.StudentFindCoursePannel;

public interface IStudentFindCoursePannelController {

	void update();

	void setStudentFindCoursePannel(StudentFindCoursePannel studentFindCoursePannel);

	void searchCourse();

	void sendPendingRequest(Course selectedCourse);

}
