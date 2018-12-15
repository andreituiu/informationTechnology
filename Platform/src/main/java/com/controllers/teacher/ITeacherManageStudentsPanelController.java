package com.controllers.teacher;

import com.model.Course;
import com.model.Student;
import com.views.teacher.TeacherManageStudentsPanel;

public interface ITeacherManageStudentsPanelController {

    void courseSelected(Course course);

    void acceptStudent(Student selectedStudent);

    void removeStudent(Student selectedStudent);

	void setTeacherManageStudentsPanel(TeacherManageStudentsPanel teacherManageStudentsPanel);

}
