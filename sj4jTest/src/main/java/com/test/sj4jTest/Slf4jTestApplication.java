package com.test.sj4jTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Slf4jTestApplication {
	
	private static Logger logger = LoggerFactory.getLogger(Slf4jTestApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(Slf4jTestApplication.class, args);
		
		logger.debug("Debug log message");
		logger.info("info log message");
		logger.error("Error log message");
		
		String variable = "Hello John";
		logger.debug("Printing variable value : {}",variable);

		String variable2 = "Hello John2";
		logger.debug("Printing variable value : {} {}",variable,variable2);
		
		if(logger.isDebugEnabled()) {
			logger.debug("Printing variable value DebugEnabled : {}", variable);
		}
		
	}

}
