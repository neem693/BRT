package com.framework.Tct.oAuth2;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	CustomDetailService customDetailService;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(
                messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        String presentedPassword = authentication.getCredentials()
            .toString();

        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
            logger.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException(
                messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
		
	}

	@Override
	protected UserDetails retrieveUser(String arg0, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
//		CustomAuthentication auth = (CustomAuthentication)authentication;
//		
//		String username = auth.getName();
//		String domain = auth.getDomain();
		
		Map<String,Object> authMap = (Map<String,Object>)authentication.getDetails();
		
		String username = authentication.getName();
		String domain33 = "";
		
		if(authMap.get("domain33") != null) {
			domain33 = authMap.get("domain33").toString();
		}
	
		System.out.println(domain33);
		
		CustomUser user = customDetailService.loadUserByUsername(username);
		//System.out.println(authentication.getDetails().toString());
		
		return user;
	}


}
