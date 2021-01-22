package com.aopTest.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcut {
	
	@Pointcut("within(@org.springframework.stereotype.Repository * )")
	public void repositoryClassMethods() {}

}
