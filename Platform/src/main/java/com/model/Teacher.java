package com.model;

public class Teacher {

	private String cnp;
	private String name;
	private String surname;
	private String password;
	private String externalEmail;
	private String internalEmail;
	
	
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
	@Override
	public String toString() {
		return name+" "+surname;
	}
	
}
