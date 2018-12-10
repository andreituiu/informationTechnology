package com.controllers.teacher;

import com.model.Course;
import com.views.teacher.TeacherCreateAssignmentFrame;

public interface ITeacherCreateAssignmentFrameController {

    void openFrame();

    void setCourse(Course course);

	void save();

	void setTeacherCreateAssignmentFrame(TeacherCreateAssignmentFrame teacherCreateAssignmentFrame);

}
