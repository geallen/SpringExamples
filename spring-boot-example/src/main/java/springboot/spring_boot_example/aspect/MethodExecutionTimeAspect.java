package springboot.spring_boot_example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionTimeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Around("@annotation(springboot.spring_boot_example.aspect.TrackTime)")
	public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		
		Object proceed = proceedingJoinPoint.proceed();
		
		long totalTime = System.currentTimeMillis() - startTime;
		
		logger.info("Time taken is : {} ms by method {} ", totalTime, proceedingJoinPoint.getSignature().getName());
		
		return proceed;
	}

}
