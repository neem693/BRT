package com.framework.Tct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockitoServiceWork {
	
	@Autowired
	MockitoService service;
	
	public MockitoServiceWork(MockitoService service) {
		this.service = service;
	}
	
	public String getMockitoWorkString() {
		return service.getMockitoService();
	}

}
