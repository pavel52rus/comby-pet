package com.task.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET).permitAll()
				.anyRequest().authenticated()
			.and()
			.httpBasic();

		return http.build();
	}

	//for abstract roles ADMIN have permissions for CRUD
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User
				.withUsername("test")
				.password("{noop}test")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
