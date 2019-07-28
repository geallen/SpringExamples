package com.example.aop.aspect.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMeasurementAspect {

	private static final Logger LOG = Logger.getLogger("TimeMeasurementAspect");
	
	@Around("firstService() || secondService()")
	public void measure(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		pjp.proceed();
		LOG.info(pjp.getTarget().getClass().getName() + " took " + (System.currentTimeMillis() - start));
	}
	
	@Pointcut("execution(* com.example.aop.aspect.services.FirstService.doSomething())")
	private void firstService() {
		
	}
	
	@Pointcut("execution(* com.example.aop.aspect.services.SecondService.doAnotherThing())")
	private void secondService() {
		
	}
}
