package com.log4j.log4jTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jTestApplication {
	
	private static Logger logger = LogManager.getLogger(Log4jTestApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(Log4jTestApplication.class, args);
		
		System.out.println("dfdsfefeeefe efefwesdf");
		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error log message");
		
		try {
			throw new Exception("new Fucking exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("exception log message",e);
			logger.trace("Trace log message");
			
		}
		
	}

}
