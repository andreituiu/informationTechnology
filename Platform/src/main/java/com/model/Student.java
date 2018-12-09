package com.model;

import java.util.Set;

public class Student {

	private String cnp;
	private String name;
	private String surname;
	private String password;
	private String externalEmail;
	private String internalEmail;
	private String specialization;
	private Integer studyYear;
	private Set<Course> enrolledCourses;
	private Set<StudentAssignment> studentAssignment;
	
	
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExternalEmail() {
		return externalEmail;
	}
	public void setExternalEmail(String externalEmail) {
		this.externalEmail = externalEmail;
	}
	public String getInternalEmail() {
		return internalEmail;
	}
	public void setInternalEmail(String internalEmail) {
		this.internalEmail = internalEmail;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
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
	
	public Set<StudentAssignment> getStudentAssignment() {
		return studentAssignment;
	}
	public void setStudentAssignment(Set<StudentAssignment> studentAssignment) {
		this.studentAssignment = studentAssignment;
	}
	
	
}
