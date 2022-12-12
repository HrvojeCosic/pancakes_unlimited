package com.example.pancakes_unlimited;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfiguration {

    @Bean
    protected InMemoryUserDetailsManager configureAuthentication() {
        List<UserDetails> userDetails = new ArrayList<>();
        List<GrantedAuthority> employeeRoles = new ArrayList<>();
        List<GrantedAuthority> customerRoles = new ArrayList<>();
        List<GrantedAuthority> storeOwnerRoles = new ArrayList<>();

        employeeRoles.add(new SimpleGrantedAuthority("EMPLOYEE"));
        customerRoles.add(new SimpleGrantedAuthority("CUSTOMER"));
        storeOwnerRoles.add(new SimpleGrantedAuthority("STORE_OWNER"));

        userDetails.add(new User("customer",
                "$2a$12$s0XBwYyrnZkyHUN1iIoaUux26X9sVi9D4VQVfkqZPFwzXw3pUwin2",
                customerRoles));
        userDetails.add(new User("employee",
                "$2a$12$KHlbbvTy2q9A2hVjKX6d4.zzpMBGGPqeQKyjRZvsvDkBEWOij9lGq",
                employeeRoles));
        userDetails.add(new User("owner",
                "$2a$12$UWlVqA2qy69SKqqKjc8YcO7nDnU3MSzy/VjkerYwTGbv6wQO1zrQS",
                storeOwnerRoles));
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .cors().and()
            .authorizeHttpRequests(authorize ->
                authorize
                    .requestMatchers("/api/v1/ingredient/**").hasAuthority("EMPLOYEE")
                    .requestMatchers("/api/v1/order/**", "/api/v1/pancake/*").hasAuthority("CUSTOMER")
                    .requestMatchers("/api/v1/report/*").hasAuthority("STORE_OWNER"))
                .httpBasic();
        return http.build();
    }
}
