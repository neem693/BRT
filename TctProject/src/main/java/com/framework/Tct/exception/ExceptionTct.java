package com.framework.Tct.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionTct extends RuntimeException {
	
	private Object data;
	
	public ExceptionTct() {
		// TODO Auto-generated constructor stub
		super();
		data = null;
	}
	
	public ExceptionTct(Object data) {
		this();
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	


}
