package com.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import simpleaspect.SimpleService;

@SpringBootApplication
public class AspectExampleApplication {

	@Autowired
	SimpleService simpleService;
	public static void main(String[] args) {
		
		SpringApplication.run(AspectExampleApplication.class, args);
		
		
	}

}
