package com.example.OnlineBookStore.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http.authorizeHttpRequests(configurer ->
			configurer
			.requestMatchers("/delete/**").hasAnyRole("MANAGER","ADMIN")
			.requestMatchers("/showFormForUpdate/**").hasAnyRole("MANAGER","ADMIN","EMPLOYEE")
			.requestMatchers("/showFormForAdd/**").hasAnyRole("MANAGER","ADMIN")
			.requestMatchers("/hr/**").hasAnyRole("MANAGER","ADMIN","EMPLOYEE")
			.requestMatchers("/it/**").hasRole("ADMIN")
			.requestMatchers("/management/**").hasRole("MANAGER")
			.requestMatchers("/list").permitAll()
			
				.anyRequest().authenticated()
		)
			.formLogin(form -> 
			form
				
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl(("/authenticateTheUser"))
				.permitAll()
		)
			.logout(logout -> logout.permitAll()
			)
			.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied")
					);
			
			
			
		
		return http.build();
		
	}
}

