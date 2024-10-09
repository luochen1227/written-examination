package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;  
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;  
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  
import org.springframework.security.crypto.password.PasswordEncoder;  
import org.springframework.security.web.SecurityFilterChain;  

import java.util.Collections;  

@Configuration  
@EnableWebSecurity  
public class SecurityConfig {  

    @Bean  
    public PasswordEncoder passwordEncoder() {  
        return new BCryptPasswordEncoder();  
    }  

    @Bean  
    public UserDetailsService userDetailsService() {  
        return username -> {
            if ("user".equals(username)) {  
                return User.withUsername("test")
                        .password(passwordEncoder().encode("123456"))
                        .roles("USER")  
                        .build();  
            } else {  
                throw new UsernameNotFoundException("User not found");  
            }  
        };  
    }  


}