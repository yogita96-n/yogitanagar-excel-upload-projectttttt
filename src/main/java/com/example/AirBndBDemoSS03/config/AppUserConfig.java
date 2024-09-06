package com.example.AirBndBDemoSS03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppUserConfig {
    @Bean
    public SecurityFilterChain secureFilter(HttpSecurity http)throws Exception{
        http.csrf(cs->cs.disable());
        http.authorizeHttpRequests(auth->auth.anyRequest().permitAll());
        return http.build();
    }

}
