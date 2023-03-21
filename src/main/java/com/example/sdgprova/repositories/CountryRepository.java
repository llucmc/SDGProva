package com.example.sdgprova.repositories;

import com.example.sdgprova.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
