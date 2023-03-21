package com.example.sdgprova.services;

import com.example.sdgprova.domain.Country;
import com.example.sdgprova.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService{

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> saveAllCountries(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }

}
