package com.example.portalsecurity.security.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

    //start 2.3.5
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    //end 2.3.5

    //start 7.1.1
    //Bean
    public UserDetailsService userDetailsService1() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                .authorities("READ")
                .build();
        var user2 = User.withUsername("jane")
                .password("12345")
                .authorities("WRITE")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    //@Bean
    public UserDetailsService userDetailsService2() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                .authorities("READ")
                .build();
        var user2 = User.withUsername("jane")
                .password("12345")
                .authorities("READ", "WRITE", "DELETE")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }
    //end 7.1.1

    //start 7.1.2
    //@Bean
    public UserDetailsService userDetailsService3() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                .authorities("ROLE_ADMIN")
                .build();
        var user2 = User.withUsername("jane")
                .password("12345")
                .authorities("ROLE_MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }

    @Bean
    public UserDetailsService userDetailsService4() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("john")
                .password("12345")
                .roles("ADMIN")
                .build();
        var user2 = User.withUsername("jane")
                .password("12345")
                .roles("MANAGER")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);

        return manager;
    }
    //end 7.1.2
}