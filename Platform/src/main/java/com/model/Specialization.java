package com.model;

public class Specialization{

	private String name;

		

	public Specialization(String string) {
		// TODO Auto-generated constructor stub
		name = string;
	}
	public Specialization() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	
	}
	@Override
	public String toString() {
		return name;
	}
	
}