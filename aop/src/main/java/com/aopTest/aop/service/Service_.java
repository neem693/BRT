package com.aopTest.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aopTest.aop.foo.Bar;
import com.aopTest.aop.foo.Foo;
import com.aopTest.aop.foo.FooDao;
import com.aopTest.aop.log.LogExecutionTime;

@Service
public class Service_ {
	
	@Autowired
	Bar bar;
	
	
	@LogExecutionTime
	public void test() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void method() {
		// TODO Auto-generated method stub
		
		bar.method(1);
		
	}

}
