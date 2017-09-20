package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{ 
  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception{
    httpSecurity.authorizeRequests()
     .antMatchers("/showCustomers", "/showProducts", "/showOrders", "/addProduct", "/addOrder", "/addCustomer")
     .hasRole("USER")
     .and()
     .formLogin()
     .and()
     .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) 
						throws Exception {
    auth.inMemoryAuthentication()
      .withUser("user").password("user").roles("USER");
  }
}
