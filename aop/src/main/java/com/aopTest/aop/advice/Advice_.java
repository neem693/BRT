package com.aopTest.aop.advice;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice_ {
	
	private Logger logger = Logger.getLogger(Advice_.class.getName());
	
	@Around("com.aopTest.aop.pointcut.Point_cut.repositoryClassMethods()")
	public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) {
		
		System.out.println("---measureMethodExecutionTime--- 어드바이스 작동");
		
		return pjp;
		
	}
	
	@Before("com.aopTest.aop.pointcut.Point_cut.targetAop()")
	public void thisMethodCall(JoinPoint jp ) {
		
		String methodName = jp.getSignature().getName();
		logger.info("Before " + methodName);
		
		return;
		
	}
	
	

}
