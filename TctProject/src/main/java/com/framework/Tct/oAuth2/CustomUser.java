package com.framework.Tct.oAuth2;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private String userId;
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomUser(UserEntity user) {
		// TODO Auto-generated constructor stub
		super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
		this.userId = "123123";
	}

}
