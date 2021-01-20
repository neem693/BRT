package com.aopTest.aop.service;

import org.springframework.stereotype.Service;

import com.aopTest.aop.log.LogExecutionTime;

@Service
public class Service_ {
	
	
	@LogExecutionTime
	public void test() throws InterruptedException {
		Thread.sleep(2000);
	}

}
