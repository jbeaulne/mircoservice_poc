package com.poc.microservice.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poc.microservice.rest.beans.Person;

public class PersonDAOImpl implements PersonDAO {

	private static final Map<String, List<Person>> PERSON_MAP = new HashMap<String, List<Person>>();
	
	static {
		List<Person> smithList = new ArrayList<Person>();
		List<Person> johnsonList = new ArrayList<Person>();
		
		smithList.add(new Person("John","Smith","Programmer"));
		
		johnsonList.add(new Person("John","Johnson","Manager"));
		johnsonList.add(new Person("Sally","Johnson","Programmer"));
		
		PERSON_MAP.put("johnson", johnsonList);
		PERSON_MAP.put("smith", smithList);
	}
	
	@Override
	public List<Person> findByLastName(String lastName) {
		if(PERSON_MAP.containsKey(lastName.toLowerCase())) {
			return PERSON_MAP.get(lastName.toLowerCase());
		} else {
			return new ArrayList<Person>();
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
