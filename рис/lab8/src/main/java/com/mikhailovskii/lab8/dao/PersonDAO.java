package com.mikhailovskii.lab8.dao;

import com.mikhailovskii.lab8.entity.Person;
import com.mikhailovskii.lab8.entity.PersonResponse;

public interface PersonDAO {

    int persistPerson(Person person);

    PersonResponse getPersonById(int id);

}
