package springboot.spring_boot_example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionTimeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Around("@annotation(springboot.spring_boot_example.aspect.TrackTime)")
	public void logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		
		proceedingJoinPoint.proceed();
		
		long totalTime = System.currentTimeMillis() - startTime;
		
		logger.info("Time taken is : {} by method {}", totalTime, proceedingJoinPoint.getSignature().getName());
	}
}
