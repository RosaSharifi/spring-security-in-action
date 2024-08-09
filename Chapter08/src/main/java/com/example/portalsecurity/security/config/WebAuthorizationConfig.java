package com.example.portalsecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class WebAuthorizationConfig {
    //start 8.1
//    @Bean
    public SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .requestMatchers("/hello").hasRole("ADMIN")
                                        .requestMatchers("/ciao").hasRole("MANAGER")
//                                       .anyRequest().permitAll() or
                                        .anyRequest().authenticated()
                );
        return http.build();
    }
    //end 8.1

    //start 8.2
//    @Bean
    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .requestMatchers(HttpMethod.GET, "/a").authenticated()
                                        .requestMatchers(HttpMethod.POST, "/a").permitAll()
                                        .anyRequest().denyAll()

                );
        return http.build();
    }

//    @Bean
    public SecurityFilterChain securityFilterChain3(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .requestMatchers("/a/b/**").authenticated()
                                        .anyRequest().permitAll()

                );
        return http.build();
    }

//    @Bean
    public SecurityFilterChain securityFilterChain4(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .requestMatchers("/product/{code:^[0-9]*$}").permitAll()
                                        .anyRequest().denyAll()
                );
        return http.build();
    }
    //end 8.2

    //start 8.3
//    @Bean
    public SecurityFilterChain securityFilterChain5(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .requestMatchers("/email/{email:.*(?:.+@.+\\.com)}").permitAll()
                                        .anyRequest().denyAll());

        return http.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain6(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorization ->
                                authorization
                                        .requestMatchers(".*/(us|uk|ca)+/(en|fr).*").authenticated()
                                        .anyRequest().hasAuthority("premium"));

        return http.build();
    }
    //end 8.3
}