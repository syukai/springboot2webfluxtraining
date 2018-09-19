package com.example.sb2train.login;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class LoginUserDetails extends User {
	
	public String username;
	

	public LoginUserDetails(String username, String password) {
		super(username, password, AuthorityUtils.createAuthorityList("USER_ROLE"));
		this.username = username;
	}

}
