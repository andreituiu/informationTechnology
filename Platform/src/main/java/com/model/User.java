package com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	
	@Id
	@Column(name = "cnp")
	private String cnp;

	private String name;
	private String surname;
	private String externalEmail;
	
	@Column(unique=true)
	private String internalEmail;
	
	@Column(name = "role", insertable = false, updatable = false)
	private String role;
	
	
	
	@Column(name = "pass")
	private String password;
	
	@OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
	private Set<Mail> sentMails;
	
	@OneToMany(mappedBy = "reciever", fetch = FetchType.EAGER)
	private Set<Mail> recievedMails;
	
    public User() {
		super();
	}
    
    

	public User(String cnp, String name, String surname, String externalEmail, String internalEmail, String password) {
		super();
		this.cnp = cnp;
		this.name = name;
		this.surname = surname;
		this.externalEmail = externalEmail;
		this.internalEmail = internalEmail;
		this.password = password;
	}



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


	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Set<Mail> getSentMails() {
		return sentMails;
	}



	public void setSentMails(Set<Mail> sentMails) {
		this.sentMails = sentMails;
	}



	public Set<Mail> getRecievedMails() {
		return recievedMails;
	}



	public void setRecievedMails(Set<Mail> recievedMails) {
		this.recievedMails = recievedMails;
	}

	


    

}
