package com.valtech.training.firstspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.training.firstspringboot.components.Arithmetic;
import com.valtech.training.firstspringboot.components.ArithmeticImpl;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.components.SimpleInterestImpl;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
		.antMatchers("/user", "/order/**","/changePassword").hasAnyRole("USER", "ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/anonymous", "/login", "/logout","/register").anonymous()
		.anyRequest().authenticated();
		
//		httpSecurity.httpBasic();
		httpSecurity.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/hello?name=Murali")
		.failureUrl("/login?error=true");
		return httpSecurity.build();
	}

	@Bean
	public Arithmetic arithmetic() {
		return new ArithmeticImpl();
	}

	@Bean
	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
		return new SimpleInterestImpl(arithmetic);
	}

//	@Bean
//	public UserDetailsManager userDetailsManager() {
//		UserDetails murali = User.builder().username("murali").password("Rajkumar@820").roles("USER").build();
//		UserDetails admin = User.builder().username("admin").password("Rajkumar@820").roles("ADMIN", "USER").build();
//		return new InMemoryUserDetailsManager(murali, admin);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

}
