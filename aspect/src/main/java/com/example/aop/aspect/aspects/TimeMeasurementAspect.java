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
	
	@Around("services()")
	public void measure(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		pjp.proceed();
		LOG.info(pjp.getTarget().getClass().getName() + " took " + (System.currentTimeMillis() - start));
	}
	
	@Pointcut("within(com.example.aop.aspect.services.*)")
	public void services() {
		
	}
	
}
