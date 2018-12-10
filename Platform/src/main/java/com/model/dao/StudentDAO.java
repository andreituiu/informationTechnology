package com.model.dao;

import java.util.List;

import com.model.Course;
import com.model.Student;

public interface StudentDAO {

	Student getStudent(String cnp);

    List<Student> getWaitingStudents(Course course);

    List<Student> getEnrolledStudents(Course course);

    void enrolleToCourse(Student selectedStudent, Course course);

    void removeFromCourse(Student selectedStudent, Course course);

	void pendingStudent(Student student, Course selectedCourse);


}
