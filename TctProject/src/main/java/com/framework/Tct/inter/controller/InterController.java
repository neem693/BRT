package com.framework.Tct.inter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inter")
public class InterController {
	
	@RequestMapping("/locale")
	public String locale() {
		return "/dontRemove/locale";
	}

}
