package com.model;

public class Mail {

	private Integer id;
	private String toCnp;
	private String fromCnp;
	private String subject;
	private String message;

	
	
	public Mail() {
		super();
	}

	public Mail(String toCnp, String fromCnp, String subject, String message) {
		super();
		this.toCnp = toCnp;
		this.fromCnp = fromCnp;
		this.subject = subject;
		this.message = message;
	}

	public String getToCnp() {
		return toCnp;
	}

	public void setToCnp(String toCnp) {
		this.toCnp = toCnp;
	}

	public String getFromCnp() {
		return fromCnp;
	}

	public void setFromCnp(String fromCnp) {
		this.fromCnp = fromCnp;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	


}
