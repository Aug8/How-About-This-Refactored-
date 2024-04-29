package com.HUFS19.backend.config;

import com.HUFS19.backend.jwt.CustumLoginFilter;
import com.HUFS19.backend.jwt.JwtFilter;
import com.HUFS19.backend.jwt.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;

    public SpringSecurityConfig(AuthenticationConfiguration authenticationConfiguration, JwtUtil jwtUtil) {

        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtUtil=jwtUtil;
    }

    //AuthenticationManager Bean 등록
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(auth->auth
                .requestMatchers(
                        "/authAPI/logout",
                        "/productAPI/like"
                        )
                .authenticated()
                .anyRequest().permitAll()
        );
         CustumLoginFilter custumLoginFilter = new CustumLoginFilter(authenticationManager(authenticationConfiguration), jwtUtil);
         custumLoginFilter.setFilterProcessesUrl("/authAPI/login");

        http.addFilterBefore(new JwtFilter(jwtUtil), CustumLoginFilter.class);
        http.addFilterAt(custumLoginFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
