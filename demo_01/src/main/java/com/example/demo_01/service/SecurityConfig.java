package com.example.demo_01.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll() // 모든 요청을 인증 없이 허용
                .and()
                .formLogin(customizer -> customizer
                        .loginPage("/login") // 사용자 정의 로그인 페이지 경로 지정
                        .permitAll()); // 로그인 페이지 접근 권한 설정
    }
}