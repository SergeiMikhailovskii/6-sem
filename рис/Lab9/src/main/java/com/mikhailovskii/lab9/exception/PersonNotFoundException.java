package com.mikhailovskii.lab9.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(int id) {
        super("Couldn't find person " + id);
    }

}
