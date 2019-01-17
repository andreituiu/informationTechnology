package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("student")
public class Student extends User {

	private Integer studyYear;
	
	
	
	@ManyToOne
	@JoinColumn(name="specialization_id", nullable=false)
	private Specialization specialization;

	@ManyToMany(cascade=CascadeType.REMOVE, mappedBy="enrolledStudents", fetch=FetchType.EAGER)
	private Set<Course> enrolledCourses;
	
	@ManyToMany(cascade=CascadeType.REMOVE, mappedBy="pendingStudents", fetch=FetchType.EAGER)
	private Set<Course> pendingCourses;

	@OneToMany(mappedBy="student", fetch=FetchType.EAGER)
	private Set<StudentAssignment> studentAssignment;
	
	
	public Student() {
		super();
	}


	public Student(String cNP, String name, String surname, String externalEmail, String internalEmail,
			String password, Integer studyYear, Specialization specialization) {
		super(cNP, name, surname, externalEmail, internalEmail, password);
		this.studyYear = studyYear;
		this.specialization = specialization;
	}


	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public Integer getStudyYear() {
		return studyYear;
	}
	public void setStudyYear(Integer studyYear) {
		this.studyYear = studyYear;
	}
	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	public Set<Course> getPendingCourses() {
		return pendingCourses;
	}
	public void setPendingCourses(Set<Course> pendingCourses) {
		this.pendingCourses = pendingCourses;
	}


	public void addPendingCourse(Course course) {
		pendingCourses.add(course);
	}


	public Set<StudentAssignment> getStudentAssignment() {
		return studentAssignment;
	}


	public void setStudentAssignment(Set<StudentAssignment> studentAssignment) {
		this.studentAssignment = studentAssignment;
	}
	
	public StudentAssignment getStudentAssignmentFor(Assignment assignment) {
		for(StudentAssignment studentAssignmentAux : studentAssignment) {
			if(studentAssignmentAux.getAssignment().equals(assignment)) {
				return studentAssignmentAux;
			}
		}
		return null;
	}
	
	
}
