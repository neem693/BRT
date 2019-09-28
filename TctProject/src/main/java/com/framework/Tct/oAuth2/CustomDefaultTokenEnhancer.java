package com.framework.Tct.oAuth2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomDefaultTokenEnhancer implements TokenEnhancer {
	

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		
		CustomUser user = (CustomUser)authentication.getPrincipal();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userId", user.getUserId());
		
		((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(map);
		
		return accessToken;
	}

}
