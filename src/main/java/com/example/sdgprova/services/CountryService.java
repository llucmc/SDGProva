package com.example.sdgprova.services;

import com.example.sdgprova.domain.Country;
import com.example.sdgprova.repositories.CountryRepository;
import com.example.sdgprova.services.DTOs.CountryDTO;
import com.example.sdgprova.services.DTOs.CountryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService{

    private final CountryRepository countryRepository;

    private final CountryMapper mapper = new CountryMapper();

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> saveAllCountries(List<CountryDTO> countriesDTO) {
        List<Country> countries = mapper.toEntityList(countriesDTO);
        return countryRepository.saveAll(countries);
    }


}
