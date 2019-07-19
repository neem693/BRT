package com.framework.Tct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTctController {
	
	@ExceptionHandler(value = ExceptionTct.class)
	public ResponseEntity<Object> tctNotFoundParam(ExceptionTct exception){
		
		if(exception.getData() == null) {
			return new ResponseEntity<Object>("올바른 파라미터를 전송해주세요.",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(exception.getData(),HttpStatus.BAD_REQUEST);
		
	}

}
