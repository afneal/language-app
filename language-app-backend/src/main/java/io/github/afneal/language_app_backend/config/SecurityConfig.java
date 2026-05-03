package io.github.afneal.language_app_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//temp file to allow testing of basic auth when spring auto security dependency will engage
//Spring Security dependency automatically authenticates, blocks all endpoints by default, shows login screen on browser
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/**").permitAll() //permit all endpoints so api can be tested
                        .anyRequest().authenticated()
                );

        return httpSecurity.build();
    }

}
