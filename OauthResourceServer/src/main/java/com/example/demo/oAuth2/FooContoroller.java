package com.example.demo.oAuth2;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooContoroller {
	
	@Autowired
	RemoteTokenServices tokenService;
	
	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET,value = "/foo/{id}")
	public Foo FindById(@PathVariable long id, @RequestHeader(value="Authorization") String accessToken) {
		
		OAuth2Authentication oauth2Auth = tokenService.loadAuthentication("ccf1abc5-67af-4fc9-a775-893a23632671");
		
		System.out.println(oauth2Auth.getPrincipal());
		
	
		return
				new Foo(Long.parseLong(RandomStringUtils.randomNumeric(2)),RandomStringUtils.randomAlphabetic(4));
	}
}
