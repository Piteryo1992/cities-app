package com.example.citiesapi.controllers;

import com.example.citiesapi.models.City;
import com.example.citiesapi.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DatabaseLoadController {

    private static final Logger log
            = LoggerFactory.getLogger(DatabaseLoadController.class);

    @Bean
    CommandLineRunner initDatabase(CityRepository repository) {
        return args -> {
            log.info("Preloading " + repository
                    .save(new City("Poznan", "Poland", 500000)));
            log.info("Preloading " + repository
                    .save(new City("Shanghai", "China", 13000000)));
            log.info("Preloading " + repository
                    .save(new City("New York", "USA", 8000000)));
        };
    }
}
