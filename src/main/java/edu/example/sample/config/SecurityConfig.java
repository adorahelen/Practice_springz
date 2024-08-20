package edu.example.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// 없어도 가능 (부트는)
public class SecurityConfig {
    @Bean // 필터체인
    public SecurityFilterChain
    securityFilterChain(HttpSecurity httpSSS)
            throws Exception {
        httpSSS.authorizeHttpRequests( // 요청 관련 인증 설정===========
                req -> req.requestMatchers(HttpMethod.POST,
                                "/display-sample/**")
                        .hasRole("ADMIN")
                        .requestMatchers(
                                "/display-sample/**"
                        ).hasAnyRole(
                                "ADMIN", "STAFF"
                        )
                        .anyRequest().permitAll()
        ).formLogin(login -> // 로그인 화면 설정 ==============
                login.loginPage("/login")
                        .defaultSuccessUrl("/display-sample")
                        .failureUrl("/login?failure")

        ).exceptionHandling(handling -> // 예외 - 접근 거부 설정==========
                handling.accessDeniedPage("/display-access-denied"));

        return httpSSS.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails hana = User.builder().username("hana")
                .password("{noop}1111")
                .roles("ADMIN")
                .build();

        UserDetails dool = User.builder().username("dool")
                .password("{noop}1111")
                .roles("STAFF")
                .build();

        UserDetails saam = User.builder().username("saam")
                .password("{noop}1111")
                .roles("GUEST")
                .build();
// noop == 암호화 되지 않았음을 의미한다.
    return new InMemoryUserDetailsManager(hana, dool, saam);
    }


}