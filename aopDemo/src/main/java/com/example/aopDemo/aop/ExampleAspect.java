package com.example.aopDemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect {
	
	@Around("@annotation(LogExcutionTime)")
	public Object logExcutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long time = System.currentTimeMillis();
		
		Object proceed = joinPoint.proceed();
		
		long excutionTime = System.currentTimeMillis() - time;
		
		System.out.println(joinPoint.getSignature()+ " excuted in " + excutionTime + "ms");
		return proceed;
		
	}

}
