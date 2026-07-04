package com.mysite.sbboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 모든 URL 요청을 로그인 없이 다 허용
        http
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers("/**").permitAll())
        ;
        return http.build();
    }

    @Bean // PasswordEncoder는 BCryptPasswordEncoder의 인터페이스
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
