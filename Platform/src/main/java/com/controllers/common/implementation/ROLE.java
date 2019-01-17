package com.controllers.common.implementation;

public enum ROLE {
	STUDENT ("student"),
	TEACHER ("teacher"),
	ADMIN ("admin");
	
	private String name;

	ROLE(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	

}
