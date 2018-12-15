package com.model;

public class User {
	private String name;
	private String surname;
	private String CNP;
	private String role;
	
	
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



    

}
