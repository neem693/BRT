package com.aopTest.aop.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.aopTest.aop.foo.Bar;
import com.aopTest.aop.foo.Foo;
import com.aopTest.aop.foo.FooDao;
import com.aopTest.aop.service.Service_;

@Component
public class Runner implements ApplicationRunner {
	
	@Autowired
	Service_ service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		service.test();
		
		service.method();
		

		
		
	}
	


}
