package com.example.citiesapi.repositories;


import com.example.citiesapi.models.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<City, Long> {

}