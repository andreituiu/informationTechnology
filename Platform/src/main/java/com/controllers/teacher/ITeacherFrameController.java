package com.controllers.teacher;

import com.model.Teacher;
import com.views.teacher.TeacherFrame;

public interface ITeacherFrameController {

	void setTeacher(Teacher teacher);

	void openFrame();

	void setTeacherFrame(TeacherFrame teacherFrame);

}
