package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		 http
         .authorizeRequests()
             .antMatchers("/", "/home","/h2-console/","/flyway").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/my-login")
             .permitAll()
             .and()
         .logout()
             .permitAll().and().headers()
				.frameOptions().sameOrigin()
				.httpStrictTransportSecurity().disable().and().csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{		
		auth.inMemoryAuthentication().withUser("jarek").password("12345").roles("USER");
	}
	
}
