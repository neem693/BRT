package com.aopTest.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Point_cut {
	
	@Pointcut("within(@org.springframework.stereotype.Repository * )")
	public void repositoryClassMethods() {}
	
	@Pointcut("within(com.aopTest.aop.foo..*)")
	public void withinClassMethods() {}
	
	@Pointcut("execution(* com.aopTest.aop.foo.Foo.*(..))")
	public void executionClassMethods() {}
	
	@Pointcut("this(com.aopTest.aop.foo.Foo)")
	public void thisAop() {};
	
	@Pointcut("target(com.aopTest.aop.foo.FooDao)")
	public void targetAop() {};
	
	@Pointcut("execution(* *..method*(Integer))")
	public void argsAop() {};
	
	@Pointcut("execution(* *..method*(Integer,..))")
	public void argsAop2() {};
	
	@Pointcut("@target(com.aopTest.aop.log.LogExecutionTime)")
	public void annotationTargetAop() {};
	
	@Pointcut("@args(com.aopTest.aop.log.LogExecutionTime))")
	public void annotationArgsAop() {};
	
	@Pointcut("@within(com.aopTest.aop.log.LogExecutionTime)")
	public void annotationWithinAop() {};
	
	@Pointcut("@annotation(com.aopTest.aop.log.LogExecutionTime)")
	public void annotationAnnoationAop() {};
	
	
	@Pointcut("com.aopTest.aop.pointcut.Point_cut.thisAop() && com.aopTest.aop.pointcut.Point_cut.targetAop()")
	public void thisTargetAop() {};
	
}
