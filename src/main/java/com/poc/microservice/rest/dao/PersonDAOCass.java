package com.poc.microservice.rest.dao;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.poc.microservice.properties.MicroServiceProperties;
import com.poc.microservice.rest.beans.Person;

public class PersonDAOCass implements PersonDAO {
	
	private Session session;
	private Cluster cluster;
	
	private static final String LAST_NAME_QUERY = "SELECT firstname, lastname, value FROM poc_microservice.person WHERE lastname = ?;";
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final String VALUE = "value";

	
	@Override
	public List<Person> findByLastName(String lastName) {
		List<Person> resultList = new ArrayList<Person>();
		ResultSet resultSet = session.execute(LAST_NAME_QUERY, lastName);
		Row row = resultSet.one();
		
		while(row != null) {
			String fn  = row.getString(FIRSTNAME);
			String ln = row.getString(LASTNAME);
			String value = row.getString(VALUE);
			resultList.add(new Person(fn,ln,value));
			row = resultSet.one(); 
		}
		
		return resultList;
	}

	@Override
	public void init() {
		cluster = Cluster.builder().addContactPoint(MicroServiceProperties.DB_HOSTNAME).withPort(MicroServiceProperties.DB_PORTNUM).build();
		session = cluster.connect();
	}

	@Override
	public void close() {
		session.close();
	}

}
