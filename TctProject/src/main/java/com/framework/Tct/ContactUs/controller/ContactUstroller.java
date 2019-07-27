package com.framework.Tct.ContactUs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="/ContactUs")
public class ContactUstroller {
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping(value ="/**")
	public String contatcUs() {
		String url = request.getRequestURI();
		System.out.println(url);
		
		return "/";
	}

}
