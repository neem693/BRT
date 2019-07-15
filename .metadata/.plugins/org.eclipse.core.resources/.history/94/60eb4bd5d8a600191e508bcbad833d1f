package com.framework.Tct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTctController {
	
	@ExceptionHandler(value = ExceptionTct.class)
	public ResponseEntity<Object> tctNotFoundParam(ExceptionTct exception){
		
		return new ResponseEntity<Object>("Tct Not Found Param",HttpStatus.BAD_REQUEST);
		
	}

}
