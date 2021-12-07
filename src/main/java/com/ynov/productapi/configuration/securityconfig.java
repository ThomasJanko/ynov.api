package com.ynov.productapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private JwtTokenFilter jwtTokenFilter;
	
	protected void configure(HttpSecurity http) throws Exception{
		http = http.cors().and().csrf().disable();
		
		//Forcer la ré Identification à chaque requete 
		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		
		http.authorizeRequests()
		.antMatchers("/api/public/**").permitAll()
		.antMatchers("/api/private/**").hasRole("USER")
		//.anyRequest().authenticated().and().httpBasic();
		.anyRequest().authenticated();
		http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	 public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	

		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception{
			String encodingPassword = passwordEncoder().encode("password");
			
			auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("romain")
			.password(encodingPassword).roles("USER");
			
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
			
			
		}
	}

