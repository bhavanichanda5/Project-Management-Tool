package com.clickup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
    	
    	 System.out.println(">>> CUSTOM SECURITY CONFIG LOADED <<<");

        http
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form.disable())
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(
            			    "/auth/**",
            			    "/workspace/**",
            			    "/project/**",
            			    "/task/**",
            			    "/space/**",
            			    "/folder/**",
            			    "/tasklist/**",
            			    "/comment/**",
            			    "/attachment/**",
            			    "/dashboard/**",
            			    "/activity/**"
            			)
            		.permitAll()
            	    .anyRequest()
            	    .authenticated()
            );

        return http.build();
    }
}