package com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Course implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
//	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	@JoinColumn(name="teacher_cnp", nullable = false)
	private Teacher teacher;

	private String name;
	
	@ManyToOne
	@JoinColumn(name="specialization_id")
	private Specialization specialization;
	private Integer year;
	private Integer semester;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable (
			name="course_student_enrolled",
			joinColumns= {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="student_cnp")}
	)
	private Set<Student> enrolledStudents;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable (
			name="course_student_pending",
			joinColumns= {@JoinColumn(name="course_id")},
			inverseJoinColumns = {@JoinColumn(name="student_cnp")}
	)
	private Set<Student> pendingStudents;
	
	
	@OneToMany(mappedBy="course", fetch=FetchType.EAGER)
	private Set<Assignment> assignments;
	
	
	public Course() {
		super();
	}
	
	
	
	public Course(String name) {
		super();
		this.name = name;
	}



	public Integer getSemester() {
		return semester;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getYear() {
		return year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}



	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}



	public Set<Student> getPendingStudents() {
		return pendingStudents;
	}



	public void setPendingStudents(Set<Student> pendingStudents) {
		this.pendingStudents = pendingStudents;
	}



	public Set<Assignment> getAssignments() {
		return assignments;
	}



	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}



	public void setPendingStudent(Student student) {
		pendingStudents.add(student);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
//	public Teacher getTeacher() {
//		return teacher;
//	}
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
//	
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Course other = (Course) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (specialization == null) {
//			if (other.specialization != null)
//				return false;
//		} else if (!specialization.equals(other.specialization))
//			return false;
//		return true;
//	}
	
	
	
	
}
