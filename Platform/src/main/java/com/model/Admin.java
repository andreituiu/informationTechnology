package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User {
	
	@Column(name = "internal_email")
	private String internalEmail;
	
	@Column(name = "external_email")
	private String externalEmail;
	
	public Admin() {
		super();
	}
	
	public Admin(String cNP, String name, String surname, String internalEmail, String externalEmail, String password) {
		super();
		setCnp(cNP);
		setName(name);
		setSurname(surname);
		this.internalEmail = internalEmail;
		this.externalEmail = externalEmail;
		setPassword(password);
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

//	public String getCnp() {
//		return CNP;
//	}
//	public void setCnp(String cNP) {
//		CNP = cNP;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//		
//	}
//	public String getPassword() {
//		return password;
//	}



//	@Override
//	public String toString() {
//		return "Admin [CNP=" + CNP + ", name=" + name + ", surname=" + surname + ", internalEmail=" + internalEmail
//				+ ", externalEmail=" + externalEmail + ", password=" + password + "]";
//	}

	
	
	


}
