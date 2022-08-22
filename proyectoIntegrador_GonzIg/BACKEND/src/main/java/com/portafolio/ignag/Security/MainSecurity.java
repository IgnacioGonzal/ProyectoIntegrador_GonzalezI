package com.portafolio.ignag.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.portafolio.ignag.Security.jwt.JwtEntryPoint;
import com.portafolio.ignag.Security.jwt.JwtTokenFilter;

public class MainSecurity {
    /* @Autowired
     UserDetailsImplements userDetailsImplements;*/
 
     @Autowired
     JwtEntryPoint jwtEntryPoint;
 
     @Bean
     public JwtTokenFilter jwtTokenFilter() {
         return new JwtTokenFilter();
     }
 
     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }
 
     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }
 
     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.cors().and().csrf().disable()
                 .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                 .authorizeRequests()
                 .antMatchers("/**").permitAll()
                 .anyRequest().authenticated();
 
         http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
 
         return http.build();
     }
 
 }