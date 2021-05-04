package com.elkTutorial.elkBoot.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ELKController {
	
	private static final Logger LOG = LogManager.getFormatterLogger(ELKController.class.getName());
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/elk")
	public String helloWorld() {
		
		String response = "Welcome to JavaInUse " + new Date();
		LOG.log(Level.INFO, response);
		
		return response;
		
	}
	
	@RequestMapping(value = "/exception")
	public String exception () {
		String response = "";
		
		try {
			throw new Exception("Exception has occured....");
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error(e);
			
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String stackTrace = sw.toString();
			LOG.error("Exception ~ " + stackTrace);
			response = stackTrace;
			
		}
		
		return response;
		
	}

}
