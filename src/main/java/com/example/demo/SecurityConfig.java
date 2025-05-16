package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.GET, "/public/resource").permitAll();
                    authorize.requestMatchers(HttpMethod.GET, "/private/write/resource").hasAuthority("SCOPE_write");
                    authorize.anyRequest().authenticated();
                })
                .oauth2ResourceServer(oauth ->
                        oauth.jwt(Customizer.withDefaults()))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
