package com.theComments.brt.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.theComments.brt.jpa.theComment.model.Eva_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUser extends User{
	
	long id;
	Integer emailValid;
	
	public CustomUser(Eva_user eva_user,Collection<GrantedAuthority> authorityList) {
		// TODO Auto-generated constructor stub
		super(eva_user.getUser_login_id(),eva_user.getPassword(),authorityList);
		this.setId(eva_user.getUser_id());
		this.setEmailValid(eva_user.getEmail_valid());
	}

}
