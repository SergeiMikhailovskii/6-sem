package com.mikhailovskii.lab9;

import com.mikhailovskii.lab9.controller.PersonController;
import com.mikhailovskii.lab9.entity.PersonResponse;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PersonModelAssembler implements RepresentationModelAssembler<PersonResponse, EntityModel<PersonResponse>> {

    @Override
    public EntityModel<PersonResponse> toModel(PersonResponse person) {
        return new EntityModel<>(person,
                linkTo(methodOn(PersonController.class).getPerson(person.getId())).withSelfRel(),
                linkTo(methodOn(PersonController.class).getAll()).withRel("persons"));
    }

}
