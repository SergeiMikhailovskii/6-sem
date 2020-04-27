package com.mikhailovskii.lab8.service;

import com.mikhailovskii.lab8.dao.PersonDAO;
import com.mikhailovskii.lab8.entity.Person;
import com.mikhailovskii.lab8.entity.PersonResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public int persistPerson(Person person) {
        return personDAO.persistPerson(person);
    }

    @Override
    public PersonResponse getPersonById(int id) {
        return personDAO.getPersonById(id);
    }

}
