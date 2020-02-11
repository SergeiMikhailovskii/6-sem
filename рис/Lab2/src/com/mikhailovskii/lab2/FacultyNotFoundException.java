package com.mikhailovskii.lab2;

public class FacultyNotFoundException extends Throwable {

    private String name;

    FacultyNotFoundException(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty with name " + name + " is not found";
    }

}
