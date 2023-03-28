package com.example.sdgprova.services.DTOs;

import com.example.sdgprova.domain.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryMapper {
    public Country toEntity(CountryDTO dto) {
        Country entity = new Country();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPopulation(dto.getPopulation());
        return entity;
    }

    public List<Country> toEntityList(List<CountryDTO> dtoList) {
        List<Country> entityList = new ArrayList<>();
        for (CountryDTO dto : dtoList) {
            entityList.add(this.toEntity(dto));
        }
        return entityList;
    }
}
