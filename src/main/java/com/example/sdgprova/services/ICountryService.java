package com.example.sdgprova.services;

import com.example.sdgprova.domain.Country;
import com.example.sdgprova.services.DTOs.CountryDTO;

import java.util.List;

public interface ICountryService {

    // Endpoint 2
    List<Country> findAllCountry();

    //Endpoint 1
    List<Country> saveAllCountries(List<CountryDTO> countries); //update also by primarykey

}
