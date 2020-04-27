package com.mikhailovskii.lab9.controller;

import com.mikhailovskii.lab9.PersonModelAssembler;
import com.mikhailovskii.lab9.entity.Person;
import com.mikhailovskii.lab9.entity.PersonResponse;
import com.mikhailovskii.lab9.exception.CitizenshipNotFoundException;
import com.mikhailovskii.lab9.exception.CityNotFoundException;
import com.mikhailovskii.lab9.exception.PersonNotFoundException;
import com.mikhailovskii.lab9.repository.CitizenshipRepository;
import com.mikhailovskii.lab9.repository.CityRepository;
import com.mikhailovskii.lab9.repository.PersonRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final CitizenshipRepository citizenshipRepository;
    private final CityRepository cityRepository;
    private final PersonModelAssembler assembler;

    public PersonController(PersonRepository repository, CitizenshipRepository citizenshipRepository, CityRepository cityRepository, PersonModelAssembler assembler) {
        this.personRepository = repository;
        this.citizenshipRepository = citizenshipRepository;
        this.cityRepository = cityRepository;
        this.assembler = assembler;
    }

    @GetMapping("/persons")
    public CollectionModel<EntityModel<PersonResponse>> getAll() {
        List<Person> persons = personRepository.findAll();
        List<PersonResponse> responses = new ArrayList<>();

        for (Person person : persons) {
            PersonResponse response = new PersonResponse(person);
            response.setCity(cityRepository.findById(person.getCity()).orElseThrow(() -> new CityNotFoundException(person.getCity())));
            response.setCitizenship(citizenshipRepository.findById(person.getCitizenShip()).orElseThrow(() -> new CitizenshipNotFoundException(person.getCitizenShip())));
            responses.add(response);
        }

        List<EntityModel<PersonResponse>> personResponses = responses.stream().map(assembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(personResponses, linkTo(methodOn(PersonController.class).getAll()).withSelfRel());
    }

    @PostMapping("/persons")
    ResponseEntity<Person> newPerson(@RequestBody Person newPerson) {
        if (newPerson.areFieldsValid()) {
            return new ResponseEntity<>(personRepository.save(newPerson), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/persons/{id}")
    public EntityModel<PersonResponse> getPerson(@PathVariable int id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        PersonResponse response = new PersonResponse(person);
        System.out.println(person.getCity() + " City id");
        response.setCity(cityRepository.findById(person.getCity()).orElseThrow(() -> new CityNotFoundException(person.getCity())));
        response.setCitizenship(citizenshipRepository.findById(person.getCitizenShip()).orElseThrow(() -> new CitizenshipNotFoundException(person.getCitizenShip())));
        return assembler.toModel(response);
    }

    @PutMapping("/persons/{id}")
    ResponseEntity<Person> replacePerson(@RequestBody Person newPerson, @PathVariable int id) {
        if (newPerson.areFieldsValid()) {
            return new ResponseEntity<>(personRepository.findById(id).map(person -> {
                newPerson.setId(id);
                return personRepository.save(newPerson);
            }).orElseGet(() -> {
                newPerson.setId(id);
                return personRepository.save(newPerson);
            }), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }

}
