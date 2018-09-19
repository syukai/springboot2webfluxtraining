package com.example.sb2train.login;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUserDetailsService implements UserDetailsService {

	private final UserRepository repository;
	
	LoginUserDetailsService(
			UserRepository repository){
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> a = repository.findByUsername(username);
		
		if(a.isPresent()) {
			return new LoginUserDetails(a.get().myName, a.get().myPass);
		}else {
			return null;
		}
	}

}
