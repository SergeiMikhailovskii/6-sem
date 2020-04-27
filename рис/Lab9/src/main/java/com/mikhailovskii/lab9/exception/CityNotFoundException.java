package com.mikhailovskii.lab9.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(int id) {
        super("Couldn't find city " + id);
    }
}
