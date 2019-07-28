package com.example.aop.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.aop.aspect.services.FirstService;
import com.example.aop.aspect.services.SecondService;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectApplication implements CommandLineRunner {

	@Autowired
	FirstService firstService;
	
	@Autowired
	SecondService secondService;
	
	public static void main(String[] args) {
		SpringApplication.run(AspectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		firstService.doSomething();
		secondService.doAnotherThing();
	}

}
