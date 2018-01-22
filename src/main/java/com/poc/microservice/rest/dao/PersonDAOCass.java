package com.poc.microservice.rest.dao;

import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.poc.microservice.properties.MicroServiceProperties;
import com.poc.microservice.rest.beans.Person;

public class PersonDAOCass implements PersonDAO {
	
	private Session session;
	private Cluster cluster;
	
	@Override
	public List<Person> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		cluster = Cluster.builder().addContactPoint(MicroServiceProperties.DB_HOSTNAME).withPort(MicroServiceProperties.DB_PORTNUM).build();
		session = cluster.connect();
	}

	@Override
	public void close() {
		cluster.close();
	}

}
