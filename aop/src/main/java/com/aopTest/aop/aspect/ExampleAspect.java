package com.aopTest.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {
	
	@Around("@annotation( com.aopTest.aop.log.LogExecutionTime )")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    long start = System.currentTimeMillis();

	    Object proceed = joinPoint.proceed();

	    long executionTime = System.currentTimeMillis() - start;

	    System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    return proceed;
	}
	

	
	@Around("repositoryClassMethods()")
	public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
		
		return pjp.proceed();
		
	}
	
	

}
