package com.mikhailovskii.lab9.exception;

public class CitizenshipNotFoundException extends RuntimeException {

    public CitizenshipNotFoundException(int id) {
        super("Couldn't find citizenship " + id);
    }
}
