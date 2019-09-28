package com.framework.Tct.oAuth2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomJwtConverter extends JwtAccessTokenConverter{
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		OAuth2AccessToken result = super.enhance(accessToken, authentication);
		DefaultOAuth2AccessToken result_default = (DefaultOAuth2AccessToken)result;
		CustomUser user = (CustomUser)authentication.getPrincipal();
		
		Map<String,Object> other_payload = new HashMap<String, Object>();
		other_payload.put("userId", user.getUserId());
		
		result_default.setAdditionalInformation(other_payload);
		
		return result_default;
	}

}
