package com.poc.microservice.rest.beans;

public class Person {
	private String firstName;
	private String lastName;
	private String value;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String value) {
		setFirstName(firstName);
		setLastName(lastName);
		setValue(value);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
