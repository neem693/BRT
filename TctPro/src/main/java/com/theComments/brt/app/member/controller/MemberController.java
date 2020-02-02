
package com.theComments.brt.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
//	private static String authorizationRequestBaseUri = "oauth2/authorization";
//	Map<String,Object> oauth2AuthenticationUrls = new HashMap<>();
//	
//	@Autowired
//	private ClientRegistrationRepository clientRegistrationRepository;
//	
//	@Autowired
//	private OAuth2AuthorizedClientService authorizedClientService;
//
//	@GetMapping("/snsLoginSuccess")
//	public String getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
//		
//		Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
//		authentication = (OAuth2AuthenticationToken)authentication1;
//		
//		
//		OAuth2AuthorizedClient client = authorizedClientService
//	      .loadAuthorizedClient(
//	        authentication.getAuthorizedClientRegistrationId(), 
//	          authentication.getName());
//	    
//	    System.out.println(client.getAccessToken());
//	    //...
//	    return "loginSuccess";
//	}
	
	
	@RequestMapping("/join")
	public String join() {
		return "index";
	}
	
	

}
