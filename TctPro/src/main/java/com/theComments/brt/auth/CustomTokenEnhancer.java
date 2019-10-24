package com.theComments.brt.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEnhancer implements TokenEnhancer{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		
		CustomUser user = (CustomUser)authentication.getPrincipal();
		Map<String,Object> map = new HashMap<>();
		map.put("userId", user.getId());
		
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(map);
		
		return accessToken;
	}
	
	

}
