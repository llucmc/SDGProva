package com.example.sdgprova.services.DTOs;

public class CountryDTO {

    private String id;
    private String name;
    private Integer population;

    public CountryDTO(){

    }
    public CountryDTO(String id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
