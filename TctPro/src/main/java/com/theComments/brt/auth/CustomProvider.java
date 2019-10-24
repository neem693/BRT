package com.theComments.brt.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.theComments.brt.constFile.AuthUser;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.model.Eva_user;

@Component
public class CustomProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	Eva_user_dao userDao;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException("4011:잘못된 파라미터입니다.");
        }

        String presentedPassword = authentication.getCredentials()
            .toString();

        if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
            logger.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException("4012:아이디 또는 패스워드가 올바르지 않습니다.");
        }
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		Map<String,Object> authMap = new HashMap<String,Object>();
		String user_login_id ="";
		
		try {
			authMap = (Map<String,Object>)authentication.getDetails();
			user_login_id = authMap.get("user_login_id").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("잘못된 파라미터");
			e.printStackTrace();
			throw new BadCredentialsException("4011:잘못된 파라미터입니다.");
		}
		
		List<Eva_user> eva_user_list = userDao.findByUserLoginId(user_login_id);
		if(eva_user_list.size() == 0) {
			logger.error("유저 존재하지 않음");
			throw new BadCredentialsException("4012:아이디 또는 패스워드가 올바르지 않습니다.");
		}
		
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(AuthUser.USER_AUTHORITY.COMMON_USER));
		
		CustomUser user = new CustomUser(eva_user_list.get(0), authList);
		
		return user;
	}
	
	

}
