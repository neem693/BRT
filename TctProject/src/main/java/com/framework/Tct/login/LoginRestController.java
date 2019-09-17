package com.framework.Tct.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Autowired
	CookieCsrfTokenRepository cookieTokenMaker;
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@RequestMapping(value="/getCsrfToken",method=RequestMethod.GET)
	public void getCsrf() {
		
//		CsrfToken csrfToken = (CsrfToken)session.getAttribute(PublicConst.SPRING_SCURITY.CSRF_TOKEN);
//		System.out.println(csrfToken.getToken());
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		CsrfToken csrf = cookieTokenMaker.loadToken(request);
		if(csrf == null) {
			csrf =cookieTokenMaker.generateToken(request);
		}
		
//		map.put("value", cookieTokenMaker.loadToken(request).getToken());
//		map.put("sessionId", session.getId());
		
		
		
		//return map;
	}
	
	@RequestMapping(value= "/login",method=RequestMethod.POST)
	public String login(@RequestBody Map<String,Object> authTry) {
		
		String username = authTry.get("username").toString();
		String password = authTry.get("password").toString();
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
		
		
		return "성공";
		
	}

}
