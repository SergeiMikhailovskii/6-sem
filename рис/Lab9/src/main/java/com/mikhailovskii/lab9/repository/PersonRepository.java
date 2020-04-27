package com.mikhailovskii.lab9.repository;

import com.mikhailovskii.lab9.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
