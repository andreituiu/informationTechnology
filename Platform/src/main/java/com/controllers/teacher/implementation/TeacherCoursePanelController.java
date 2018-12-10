package com.controllers.teacher.implementation;

import java.util.List;

import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Course;
import com.model.Teacher;
import com.model.dao.CourseDAO;
import com.views.teacher.TeacherCoursesPanel;
import com.views.teacher.TeacherPanel;

public class TeacherCoursePanelController implements ITeacherCoursePanelController {

    private TeacherPanel teacherPanel;
    private TeacherCoursesPanel teacherCoursePanel;
    private Teacher teacher;
    private CourseDAO coursesDAO;
    private ITeacherManageStudentsPanelController teacherManageStudentsPanelController;
    private ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelConttoller;

    
    
    public TeacherCoursePanelController(Teacher teacher, CourseDAO coursesDAO,
			ITeacherManageStudentsPanelController teacherManageStudentsPanelController,
			ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelConttoller) {
		super();
		this.teacher = teacher;
		this.coursesDAO = coursesDAO;
		this.teacherManageStudentsPanelController = teacherManageStudentsPanelController;
		this.teacherManageAssignmentsPanelConttoller = teacherManageAssignmentsPanelConttoller;
	}

	@Override
    public void courseSelected(Course course) {
        teacherManageStudentsPanelController.courseSelected(course);
        teacherManageAssignmentsPanelConttoller.courseSelected(course);
    }

    @Override
    public void viewCourse() {
        List<Course> courses = coursesDAO.getCoursesForTeacher(teacher);
        teacherCoursePanel.populateCourses(courses);
        teacherPanel.setPanel(teacherCoursePanel);
    }

    @Override
	public void setTeacherPanel(TeacherPanel teacherPanel) {
		this.teacherPanel = teacherPanel;
	}

    @Override
	public void setTeacherCoursePanel(TeacherCoursesPanel teacherCoursePanel) {
		this.teacherCoursePanel = teacherCoursePanel;
	}
    
    

}
