package com.theComments.brt.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.theComments.brt.jpa.theComment.model.Eva_user;

public class CustomUser extends User{
	
	long id;
	
	public CustomUser(Eva_user eva_user,Collection<GrantedAuthority> authorityList) {
		// TODO Auto-generated constructor stub
		super(eva_user.getUser_login_id(),eva_user.getPassword(),authorityList);
		this.setId(eva_user.getUser_id());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
