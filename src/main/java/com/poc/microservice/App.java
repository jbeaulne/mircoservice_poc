package com.poc.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poc.microservice.properties.MicroServiceProperties;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
    public static void main( String[] args )
    {
    		if(args.length < 2) {
    			System.out.println("DB hostname and port number required");
    		} else {
    			MicroServiceProperties.DB_HOSTNAME = args[0];
    			MicroServiceProperties.DB_PORTNUM = Integer.parseInt(args[1]);
    			SpringApplication.run(App.class,args);
    		}
        
    }
}
