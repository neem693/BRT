package com.aopTest.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice_ {
	
	@Around("com.aopTest.aop.pointcut.Point_cut.repositoryClassMethods()")
	public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) {
		
		System.out.println("---measureMethodExecutionTime--- 어드바이스 작동");
		
		return pjp;
		
	}

}
