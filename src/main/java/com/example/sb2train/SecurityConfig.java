package com.example.sb2train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/bcrypt/**","/login").permitAll()
				.anyRequest().authenticated().and()
			.formLogin().loginPage("/login")
					.usernameParameter("username")
					.passwordParameter("password")
				.loginProcessingUrl("/login")
				.successForwardUrl("/success")
				.failureUrl("/failure");
		
	}
	
	
	@Configuration
	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter{
		UserDetailsService userDetailsService;
		
		AuthenticationConfiguration(
				UserDetailsService userDetailsService){
			this.userDetailsService = userDetailsService;
		}
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService)
				.passwordEncoder(new BCryptPasswordEncoder());
		}
	}
	
}
