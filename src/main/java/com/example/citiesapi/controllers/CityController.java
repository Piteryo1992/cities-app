package com.example.citiesapi.controllers;

import com.example.citiesapi.models.City;
import com.example.citiesapi.repositories.CityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityRepository cityRepository;

    CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping()
    public List<City> list() {
        return cityRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<City> get(@PathVariable Long id) {
        return cityRepository.findById(id);
    }

    @PostMapping
    public City create(@RequestBody final City city) {
        return cityRepository.save(city);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public City update(@PathVariable Long id, @RequestBody City city) {
        City existingCity = cityRepository.getOne(id);
        BeanUtils.copyProperties(city, existingCity, "id");
        return cityRepository.saveAndFlush(existingCity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        cityRepository.deleteById(id);
    }


}
