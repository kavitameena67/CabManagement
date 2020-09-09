package com.kavitameena.cabmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Inter-City Cab Management Portal
 * Admin - manages cabs, drivers, riders, trips, locations
 * User - request a ride
 */

@SpringBootApplication
public class CabmanagementApplication {

	private static final Logger logger = LoggerFactory.getLogger(CabmanagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CabmanagementApplication.class, args);
	}

}
