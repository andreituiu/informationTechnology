package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentAssignment implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="assignment_id", nullable=false)
    private Assignment assignment;
	
	@ManyToOne
	@JoinColumn(name="student_cnp", nullable=false)
	private Student student;
	
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
    
    
}