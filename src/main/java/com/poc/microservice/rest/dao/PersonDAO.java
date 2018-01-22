package com.poc.microservice.rest.dao;

import java.util.List;

import com.poc.microservice.rest.beans.Person;

public interface PersonDAO {
	
	public List<Person> findByLastName(String lastName);
	
	public void init();
	public void close();
}
