package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	
	@Id
	@Column(name = "cnp")
	private String CNP;

	private String name;
	private String surname;
	private String externalEmail;
	private String internalEmail;
	
	@Column(name = "role", insertable = false, updatable = false)
	private String role;
	
	
	
	@Column(name = "pass")
	private String password;
	
	
    public User() {
		super();
	}
    
    

	public User(String cNP, String name, String surname, String externalEmail, String internalEmail, String password) {
		super();
		CNP = cNP;
		this.name = name;
		this.surname = surname;
		this.externalEmail = externalEmail;
		this.internalEmail = internalEmail;
		this.password = password;
	}



	public String getCnp() {
       return CNP;
    }
	
	public void setCnp(String cNP) {
		CNP = cNP;
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
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInternalEmail() {
		return internalEmail;
	}

	public void setInternalEmail(String internalEmail) {
		this.internalEmail = internalEmail;
	}

	public String getExternalEmail() {
		return externalEmail;
	}

	public void setExternalEmail(String externalEmail) {
		this.externalEmail = externalEmail;
	}



	public String getCNP() {
		return CNP;
	}



	public void setCNP(String cNP) {
		CNP = cNP;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



    

}
