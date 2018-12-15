package com.controllers.student;

import com.model.Student;
import com.model.User;
import com.views.student.StudentFrame;

public interface IStudentFrameController {

	void openFrame();

	void setStudent(Student student);

	void setStudentFrame(StudentFrame studentFrame);

	void setUser(User user);

}
