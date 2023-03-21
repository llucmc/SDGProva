package com.example.sdgprova.services;

import com.example.sdgprova.domain.Country;

import java.util.List;

public interface ICountryService {

    // Endpoint 2
    List<Country> findAllCountry();

    //Endpoint 1
    List<Country> saveAllCountries(List<Country> countries); //update also by primarykey
}
