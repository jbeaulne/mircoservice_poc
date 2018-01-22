package com.poc.microservice.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.microservice.rest.beans.Person;
import com.poc.microservice.rest.dao.PersonDAO;
import com.poc.microservice.rest.dao.PersonDAOImpl;

@RestController
public class PersonController {
	
	@RequestMapping("/person")
	public List<Person> getPeople(@RequestParam(value="lastName") String lastName){
		PersonDAO personDAO = new PersonDAOImpl();
		List<Person> result;
		try {
			personDAO.init();
			result = personDAO.findByLastName(lastName);
		} finally {
			personDAO.close();
		}
		return result;
	}
}
