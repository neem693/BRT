package com.framework.Tct.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestIndex {
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/list_data")
	public String list_data() {
		return "list_data";
	}
	
	@RequestMapping(value = "/add_data")
	public String add_data() {
		return "add_data";
	}
	
	

}
