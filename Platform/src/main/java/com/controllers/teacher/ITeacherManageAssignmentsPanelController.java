package com.controllers.teacher;

import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.views.teacher.TeacherManageAssignmentsPanel;

public interface ITeacherManageAssignmentsPanelController {

    void courseSelected(Course course);

    void createAssignment();

    void saveGrade();

    void studentSelected(Student student);

	void assignmentSelected(Assignment assignment);

	void setTeacherManageAssignmentsPanel(TeacherManageAssignmentsPanel teacherManageAssignmentsPanel);

	void deleteStdent(Student selectedStudent);

	void updateFields();

	void downloadFile();

}
