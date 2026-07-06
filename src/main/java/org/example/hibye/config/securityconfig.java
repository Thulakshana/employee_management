package org.example.hibye.config;

import org.example.hibye.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityconfig {
    private final JwtFilter jwt_filter_file;
    public securityconfig(JwtFilter jwt_filter_file){
        this.jwt_filter_file=jwt_filter_file;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth
                .requestMatchers("/api/users/signup","/api/users/login" ,"/swagger-ui/**",
                        "/v3/api-docs/**").permitAll().anyRequest().authenticated());
    return http.build();
    }

}
