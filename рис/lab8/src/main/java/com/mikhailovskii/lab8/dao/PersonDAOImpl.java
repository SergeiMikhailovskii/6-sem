package com.mikhailovskii.lab8.dao;

import com.mikhailovskii.lab8.entity.Citizenship;
import com.mikhailovskii.lab8.entity.City;
import com.mikhailovskii.lab8.entity.Person;
import com.mikhailovskii.lab8.entity.PersonResponse;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO {

    private final SessionFactory sessionFactory;

    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int persistPerson(Person person) {
        sessionFactory.getCurrentSession().persist(person);
        return person.getId();
    }

    @Override
    @Transactional
    public PersonResponse getPersonById(int id) {
        Person person = sessionFactory.getCurrentSession().get(Person.class, id);
        PersonResponse response = new PersonResponse(person);
        response.setCity(sessionFactory.getCurrentSession().get(City.class, person.getCity()));
        response.setCitizenship(sessionFactory.getCurrentSession().get(Citizenship.class, person.getCitizenShip()));
        return response;
    }

}
