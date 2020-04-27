package com.mikhailovskii.lab9.repository;

import com.mikhailovskii.lab9.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
