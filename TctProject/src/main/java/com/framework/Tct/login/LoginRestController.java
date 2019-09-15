package com.framework.Tct.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.Tct.Const.PublicConst;

@RestController
public class LoginRestController {
	
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value="/getCsrfToken",method=RequestMethod.GET)
	public Map<String,Object> getCsrf() {
		
//		CsrfToken csrfToken = (CsrfToken)session.getAttribute(PublicConst.SPRING_SCURITY.CSRF_TOKEN);
//		System.out.println(csrfToken.getToken());
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("value", "fwefw");
		
		return map;
	}

}
