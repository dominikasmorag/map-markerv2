package com.dominika.springbootapp.configuration;

import com.dominika.springbootapp.entity.User;
import com.dominika.springbootapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {
    UserRepository repository;

    @Bean
    CommandLineRunner userCmdLineRunner(UserRepository repository) {
        return args -> {
            User user = new User();
            user.setUsername("test");
            user.setPassword("test");
            repository.save(user);
        };
    }
}
