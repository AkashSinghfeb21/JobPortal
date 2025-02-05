package com.Akash.jobportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Akash.jobportal.services.CustomUserDetailsService;

@Configuration
public class WebSecurityConfig {
	
	private final CustomUserDetailsService customUserDetailsService;
	
	
	@Autowired
	public WebSecurityConfig(CustomUserDetailsService customUserDetailsService) {

		this.customUserDetailsService = customUserDetailsService;
	}

	//list of public urls which doesn't require login
	private final String[] publicUrl = {"/",
			"/global-search/**",
			"/register",
			"/register/**",
			"/webjars/**",
			"/resources/**",
			"/assets/**",
			"/css/**",
			"/summernote/**",
			"/js/**",
			"/*.css",
			"/*.js",
			"/*.js.map",
			"/fonts**","/favicon.ico","/resources/**","/error"};
	 
    
	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.authenticationProvider(authenticationProvider());
		
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers(publicUrl).permitAll();//this doesn't need authentication
			auth.anyRequest().authenticated();//this need authentication
		});
		
		return http.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		authenticationProvider.setUserDetailsService(customUserDetailsService);
	    
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
