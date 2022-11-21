package com.marktProject.GroceryMarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GroceryMarketSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/sendMsg").and().authorizeRequests()
                .mvcMatchers("/home").authenticated()
                .mvcMatchers("/about").permitAll()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/sendMsg").permitAll()
                .mvcMatchers("/dash").authenticated()
                .mvcMatchers("/registration").permitAll()
                .mvcMatchers("/displayInquiries").hasRole("ADMIN")   // give permission only to admin role users
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/dash").failureUrl("/login?error=true").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true).permitAll()
                .and().httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        List<UserDetails> userDetails = new ArrayList<>();

        userDetails.add(
                User.withUsername("user")
                        .passwordEncoder(passwordEncoder() :: encode)
                        .password("0000")
                        .roles("USER")
                        .build()
        );

        userDetails.add(
                User.withUsername("admin")
                        .passwordEncoder(passwordEncoder() :: encode)
                        .password("1234")
                        .roles("ADMIN")
                        .build()
        );

        return new InMemoryUserDetailsManager(userDetails);
    }
}
