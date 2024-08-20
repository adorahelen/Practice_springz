package edu.example.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// 없어도 가능 (부트는)
public class SecurityConfig {
    @Bean // 필터체인
    public SecurityFilterChain
    securityFilterChain(HttpSecurity http, HttpSecurity httpSSS)
            throws Exception {
        httpSSS.authorizeHttpRequests(
                req -> req.requestMatchers(HttpMethod.POST,
                   "/display-sample/**")
                        .hasRole("ADMIN")
                        .requestMatchers(
                                "/display-sample/**"
                        ).hasAnyRole(
                                "ADMIN", "STAFF"
                        )
                        .anyRequest().permitAll()
        ).formLogin(login->
                login.loginPage("/login")
                        .defaultSuccessUrl("/display-sample/")
                        .failureUrl("/login?failure")

        ).exceptionHandling(handling->
                handling.accessDeniedPage("/display-access-denied"));

        return null;
    }
}
