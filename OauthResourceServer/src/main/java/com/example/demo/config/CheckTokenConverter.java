package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;



@Component
public class CheckTokenConverter extends DefaultAccessTokenConverter {
	
	private Map checkTokenResult;
	

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		// TODO Auto-generated method stub
		OAuth2Authentication auth = super.extractAuthentication(map);
		auth.setDetails(map);
		this.checkTokenResult = new HashMap(map);
		return auth;
	}
	
	public Map getCheckTokenResult() {
		return checkTokenResult;
	}

	public void setCheckTokenResult(Map checkTokenResult) {
		this.checkTokenResult = checkTokenResult;
	}


}
