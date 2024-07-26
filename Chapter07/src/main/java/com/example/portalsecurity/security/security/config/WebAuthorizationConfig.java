package com.example.portalsecurity.security.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class WebAuthorizationConfig {
    //start 7.1.1
    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        String expression1 = """
                hasAuthority('READ')
                """;

        String expression2 = """
                hasAuthority('READ')
                and !hasAuthority('DELETE')
                """;

        httpSecurity.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .anyRequest()
//                                        .hasAuthority("WRITE")); or
//                                        .hasAnyAuthority("WRITE", "READ")); or
//                                        .access(new WebExpressionAuthorizationManager(expression1))); or
                                        .access(new WebExpressionAuthorizationManager(expression2)));
        return httpSecurity.build();
    }
    //end 7.1.1

    //start 7.1.2
    @Bean
    public SecurityFilterChain securityFilterChain1(HttpSecurity httpSecurity) throws Exception {

        String expression1 = """
                hasRole('ADMIN')
                """;

        String expression2 = """
                hasRole('ADMIN')
                and !hasRole('MANAGER')
                """;

        httpSecurity.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .anyRequest()
//                                        .hasRole("ADMIN")); or
//                                        .hasAnyRole("ADMIN", "MANAGER")); or
//                                        .access(new WebExpressionAuthorizationManager(expression1))); or
                                        .access(new WebExpressionAuthorizationManager(expression2)));
        return httpSecurity.build();
    }
    //end 7.1.2
}