package com.model.utils;

public enum UserType {
	
	TEACHER("teacher"),
	ADMIN("admin"),
	STUDENT("student");

	private String name;
	
	private UserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
