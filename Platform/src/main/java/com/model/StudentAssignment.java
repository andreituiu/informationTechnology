package com.model;

import java.util.Date;

public class StudentAssignment {

	private Assignment assignment;
	private Date lastUpdate;
	private Double grade;
	
	
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	public Date getDeadline() {
		return assignment.getDeadline();
	}
	
	
}
