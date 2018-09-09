package com.example.sb2train;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
         http
         	.authorizeExchange().pathMatchers("/train/").permitAll()
         	.and()
         	.authorizeExchange().pathMatchers("/train/echo").permitAll()
         	.and()
         	.authorizeExchange().pathMatchers("/train/simpletext").permitAll()
         	.and()
         	.authorizeExchange().pathMatchers("/train/stream").hasRole("USER_ROLE")
         	.and().csrf().disable();
         	
         return http.build();
    }
}
