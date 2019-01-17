package com.model.dao;

import java.util.List;

import com.model.Assignment;
import com.model.Course;
import com.model.Student;
import com.model.StudentAssignment;

public interface AssignmentDAO {

    List<StudentAssignment> getAllAssignmentsFor(Course course, Student student);

    List<Assignment> getAssignmentsFor(Course course);

    void save(StudentAssignment studentAssignment);

	StudentAssignment getStudentAssignment(Student student, Assignment assignment);

	void save(Assignment assignment);

}
