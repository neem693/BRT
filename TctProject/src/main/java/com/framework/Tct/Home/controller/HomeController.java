package com.framework.Tct.Home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="/Home")
public class HomeController {
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping(value ="/**")
	public String home() {
		String url = request.getRequestURI();
		System.out.println(url);
		
		return "/";
	}
	
	

}
