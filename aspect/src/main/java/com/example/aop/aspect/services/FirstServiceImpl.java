package com.example.aop.aspect.services;

import org.springframework.stereotype.Service;

@Service
public class FirstServiceImpl implements FirstService{

	@Override
	public void doSomething() {
		// some business logic
		
		try {
		//	long start = System.currentTimeMillis();
			System.out.println("Inside First Service ");
			Thread.sleep(500);
			
			//System.out.println("First Service took " + (System.currentTimeMillis() - start));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
}
