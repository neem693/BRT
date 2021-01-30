package com.example.aopDemo;

import org.springframework.stereotype.Service;

import com.example.aopDemo.aop.LogExcutionTime;

@Service
public class ServiceAop {

	
	@LogExcutionTime
	public void serve() throws InterruptedException {
		Thread.sleep(2000);
	}

	
	
}
