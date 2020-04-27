package com.mikhailovskii.lab9.repository;

import com.mikhailovskii.lab9.entity.Citizenship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenshipRepository extends JpaRepository<Citizenship, Integer> {
}
