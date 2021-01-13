package com.example.citiesapi.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonPropertyOrder({ "id", "name", "country", "population" })
public class City {
    private @Id @GeneratedValue
    Long id;

    private String name;
    private String country;
    private int population;

    public City() {

    }

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof City))
            return false;
        City city = (City) o;
        return Objects.equals(this.id, city.id) && Objects.equals(this.name, city.name)
                && Objects.equals(this.country, city.country) && Objects.equals(this.population, city.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.country, this.population);
    }

    @Override
    public String toString() {
        return "City{" + "id=" + this.id + ", name='" + this.name + '\'' + ", country='" + this.country
                + '\'' + ", population='" + this.population + '\'' + '}';
    }
}
