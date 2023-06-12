package com.dominika.springbootapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("test")
                        .password("{noop}password")
                        .roles("ADMIN")
                        .build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("\n\n\n****\n\nSecurityConfig.securityFilterChain");
        if(applicationContext == null ) {
            System.out.println("context is null");
        }
        Customizer<CsrfConfigurer<HttpSecurity>> customizer = httpSecurityCsrfConfigurer -> {
            CsrfConfigurer<HttpSecurity> configurer = new CsrfConfigurer<>(applicationContext);
            configurer.setBuilder(http);
            configurer.disable();

        };
        System.out.println("customizer created");
        return http
                .csrf(customizer)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource).usersByUsernameQuery(
                        "select username, password, 1 " +
                        "from users " +
                        "where username = ?"
                ).authoritiesByUsernameQuery();
    }

}
