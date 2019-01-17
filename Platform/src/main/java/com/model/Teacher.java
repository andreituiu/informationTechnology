package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends User {

	@OneToMany(mappedBy = "teacher", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Course> courses = new HashSet<>();


	public Teacher() {
		super();
	}


	public Teacher(String cNP, String name, String surname, String externalEmail, String internalEmail,
			String password) {
		super(cNP, name, surname, externalEmail, internalEmail, password);
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	public void addCourse(Course c) {
		courses.add(c);
	}


	@Override
	public String toString() {
		return getName() + " " + getSurname();
	}

	
	
	


}
