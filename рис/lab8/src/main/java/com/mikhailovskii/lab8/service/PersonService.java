package com.mikhailovskii.lab8.service;

import com.mikhailovskii.lab8.entity.Person;
import com.mikhailovskii.lab8.entity.PersonResponse;

public interface PersonService {

    int persistPerson(Person person);

    PersonResponse getPersonById(int id);

}
