package com.controllers.teacher.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.controllers.teacher.ITeacherCoursePanelController;
import com.controllers.teacher.ITeacherManageAssignmentsPanelController;
import com.controllers.teacher.ITeacherManageStudentsPanelController;
import com.model.Course;
import com.model.Teacher;
import com.model.dao.CourseDAO;
import com.model.repository.CourseRepository;
import com.views.teacher.TeacherCoursesPanel;
import com.views.teacher.TeacherPanel;

import javafx.scene.Node;

@Component
public class TeacherCourseController implements ITeacherCoursePanelController {

	@Autowired
    private TeacherPanel teacherPanel;
    
    @Autowired
    private TeacherCoursesPanel teacherCoursePanel;
    private Teacher teacher;
    
    @Autowired
    private CourseRepository coursesRepository;
    
    @Autowired
    private ITeacherManageStudentsPanelController teacherManageStudentsPanelController;
    
    @Autowired
    private ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelConttoller;
	private Node coursesPanel;

    
    
    public TeacherCourseController(Teacher teacher, CourseDAO coursesDAO,
			ITeacherManageStudentsPanelController teacherManageStudentsPanelController,
			ITeacherManageAssignmentsPanelController teacherManageAssignmentsPanelConttoller) {
		super();
		this.teacher = teacher;
		this.coursesRepository = coursesDAO;
		this.teacherManageStudentsPanelController = teacherManageStudentsPanelController;
		this.teacherManageAssignmentsPanelConttoller = teacherManageAssignmentsPanelConttoller;
	}

	public TeacherCourseController() {
		super();
	}

	@Override
    public void courseSelected(Course course) {
        teacherManageStudentsPanelController.courseSelected(course);
        teacherManageAssignmentsPanelConttoller.courseSelected(course);
    }

    @Override
    public void viewCourse() {
        List<Course> courses = new ArrayList<>(teacher.getCourses());
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

	@Override
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public Node getCoursesPanel() {
		return coursesPanel;
	}

	public void setCoursesPanel(Node coursesPanel) {
		this.coursesPanel = coursesPanel;
		
	}
    
    

}
