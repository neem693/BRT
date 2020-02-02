package com.theComments.brt.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sun.xml.bind.v2.TODO;
import com.theComments.brt.constFile.AuthUser;
import com.theComments.brt.constFile.SNS;
import com.theComments.brt.jpa.theComment.dao.Eva_user_dao;
import com.theComments.brt.jpa.theComment.dao.SnsUser_dao;
import com.theComments.brt.jpa.theComment.model.Eva_user;
import com.theComments.brt.jpa.theComment.model.Sns_user;

@Component
public class CustomProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	Eva_user_dao userDao;
	@Autowired
	SnsUser_dao snsDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	SNSAuthorization snsAuthorization;

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
		//sns 로그인일 경우/////////////
		String snsType = "";
		String access_token = "";
		Map<String,Object> snsResult = new HashMap<String, Object>();
		////////////////////////////
		
		try {
			authMap = (Map<String,Object>)authentication.getDetails();
			user_login_id = authMap.get("user_login_id").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("잘못된 파라미터");
			e.printStackTrace();
			throw new BadCredentialsException("4011:잘못된 파라미터입니다.");
		}
		
		
		
		Eva_user targetUser = null;
		/////////////////////sns 로그인일 경우 체크
		if(authMap.get("snsType") != null) {
			
			//sns 로그인에 대한 신호
			snsType = authMap.get("snsType").toString();
			access_token = authMap.get("access_token").toString();
			
			if(snsType.equals(SNS.GOOGLE.snsType)) {
				snsResult = this.snsAuthorization.oAuth2TokenApi(snsType, access_token);
				if(snsResult.get("user_id").toString().equals(user_login_id) == false) {
					throw new BadCredentialsException("4021:sns auth error");
				}
			}
			
			Optional<Sns_user> sns_user = snsDao.findSnsUser(user_login_id, snsType);
			if(sns_user.isPresent() == false) {
				throw new BadCredentialsException("4022:sns user not registed");
			}
			
			targetUser =  sns_user.get().getEva_user();
			
		}else {
			////////////////////sns 로그인일 경우 체크 끝
			//일반 로그인 시작//
			
			List<Eva_user> eva_user_list = userDao.findByUserLoginId(user_login_id);
			if(eva_user_list.size() == 0) {
				logger.error("유저 존재하지 않음");
				throw new BadCredentialsException("4012:아이디 또는 패스워드가 올바르지 않습니다.");
			}
			
			targetUser = eva_user_list.get(0);
			
		}
		///일반 로그인 체크 끝
		
		
		//////권한 위임
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority(AuthUser.USER_AUTHORITY.COMMON_USER));
		
		CustomUser user = new CustomUser(targetUser, authList);
		
		return user;
		/////////////
	}
	
	

}
