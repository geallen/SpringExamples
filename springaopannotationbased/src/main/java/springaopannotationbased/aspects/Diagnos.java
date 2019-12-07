package springaopannotationbased.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Diagnos {

	@Pointcut("execution(* springaopannotationbased.cars.*.*(..))")
	public void run() {}
	
	@Pointcut("within(springaopannotationbased.cars.*)")
	public void test() {}
	
//	@Before("run())")
//	public void beforeAdvice() {
//		System.out.println("Checking engine before");
//	}
	
//	@After("run()")
//	public void afterAdvice() {
//		System.out.println("Checking engine after");
//	}
	
//	@AfterReturning("run()")
//	public void afterReturning() {
//		System.out.println("After returning");
//	}
	
	@AfterThrowing("run()")
	public void afterThrowing() {
		System.out.println("After throwing");
	}
//	
//	@Around("run()")
//	public void aroundAdvice(ProceedingJoinPoint pj) {
//		System.out.println("Around advice is called");
//		try {
//			pj.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Around advice later called");
//	}
	
	@Before("test()")
	public void before(JoinPoint jp) {
		System.out.println(jp.toString());
		System.out.println("Before advice is called");
	}
}
