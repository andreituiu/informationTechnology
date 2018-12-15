package com.model;

public class Admin {
	
	private String name;
	private String surname;
	private String CNP;
	private String internalEmail;
	private String externalEmail;
	private String password;
	
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
	public String getCnp() {
		return CNP;
	}
	public void setCnp(String cNP) {
		CNP = cNP;
	}
	public void setPassword(String password) {
		this.password = password;
		
	}
	public String getPassword() {
		return password;
	}

	


}
