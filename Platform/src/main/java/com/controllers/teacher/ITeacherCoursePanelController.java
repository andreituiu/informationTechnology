package com.controllers.teacher;

import com.model.Course;
import com.model.Teacher;
import com.views.teacher.TeacherCoursesPanel;
import com.views.teacher.TeacherPanel;

public interface ITeacherCoursePanelController {

    void courseSelected(Course selectedValue);

    void viewCourse();

	void setTeacherCoursePanel(TeacherCoursesPanel teacherCoursePanel);

	void setTeacherPanel(TeacherPanel teacherPanel);

	void setTeacher(Teacher teacher);

	void searchCourses();

}
