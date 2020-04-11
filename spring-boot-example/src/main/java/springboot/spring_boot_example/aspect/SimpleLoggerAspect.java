package springboot.spring_boot_example.aspect;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SimpleLoggerAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* springboot.spring_boot_example.service.TodoService.createOrUpdateTodo(..))")
	public void logBeforeMethod(JoinPoint joinPoint) {
		
		//show method name
		logger.info("Simple logger aspect before method : " + joinPoint.getSignature().getName()+ " with parameters " + joinPoint.getArgs());
	}
	
	@Before("execution(* springboot.spring_boot_example.dao.TodoRepository.*(..))")
	public void logAllDatabaseRecordMethods(JoinPoint joinPoint) {
		logger.info("Database method : " + joinPoint.getSignature().getName());
		
	}
	
}
