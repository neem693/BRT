package com.framework.Tct.oAuth2;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomUser(UserEntity user) {
		// TODO Auto-generated constructor stub
		super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
	}

}
