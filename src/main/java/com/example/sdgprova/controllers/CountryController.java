package com.example.sdgprova.controllers;

import com.example.sdgprova.domain.Country;
import com.example.sdgprova.services.CountryService;
import com.example.sdgprova.services.DTOs.CountryDTO;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
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
    public List<Country> saveAllCountries() {

        String url = "https://restcountries.com/v3.1/all";
        //"https://restcountries.com/v3.1/all";

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
        List<CountryDTO> countryDTOs = new ArrayList<>();
        for (int i = 0; i < officialNames.size(); i++) {
            CountryDTO countryDTO = new CountryDTO();
            countryDTO.setId(countryCodes.get(i));
            countryDTO.setName(officialNames.get(i));
            countryDTO.setPopulation(populations.get(i));
            countryDTOs.add(countryDTO);
        }
        return countryService.saveAllCountries(countryDTOs);

    }

}

