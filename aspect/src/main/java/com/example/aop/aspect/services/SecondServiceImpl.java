package com.example.aop.aspect.services;

import org.springframework.stereotype.Service;

@Service
public class SecondServiceImpl implements SecondService {

	@Override
	public void doAnotherThing() {
		// business logic
		try {
			
		//	long start = System.currentTimeMillis();
			System.out.println("Inside Second Service ");
			Thread.sleep(200);
			//System.out.println("Second Service took: " + (System.currentTimeMillis()- start));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
