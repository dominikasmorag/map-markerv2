package com.dominika.springbootapp.configuration;

import com.dominika.springbootapp.entity.Place;
import com.dominika.springbootapp.repository.PlaceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlaceConfig {
    PlaceRepository repository;
    @Bean
    CommandLineRunner placeCmdLineRunner(PlaceRepository repository) {
        return args -> {
            List<Place> list = List.of(

            );
        };

    }
}
