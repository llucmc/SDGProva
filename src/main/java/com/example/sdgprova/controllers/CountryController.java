package com.example.sdgprova.controllers;

import com.example.sdgprova.domain.Country;
import com.example.sdgprova.services.CountryService;
import com.jayway.jsonpath.JsonPath;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/data/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAllCountry() {
        return countryService.findAllCountry();
    }

    @PostMapping
    public List<Country> saveCountry(){

        String url = "https://restcountries.com/v3.1/all";

        //configure the paths
        String countryCodesPath = "$[*].cca2";
        String officialNamePath = "$[*].name.official";
        String populationPath = "$[*].population";

        //get Response
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        //Save response parameters into lists
        List<String> countryCodes = JsonPath.read(jsonResponse, countryCodesPath);
        List<String> officialNames = JsonPath.read(jsonResponse, officialNamePath);
        List<Integer> populations = JsonPath.read(jsonResponse, populationPath);

        //Add parameters to a List<Country>
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < officialNames.size(); i++) {
            Country country = new Country();
            country.setId(countryCodes.get(i));
            country.setName(officialNames.get(i));
            country.setPopulation(populations.get(i));
            countries.add(country);

        }
        return countryService.saveAllCountries(countries);

    }
}

