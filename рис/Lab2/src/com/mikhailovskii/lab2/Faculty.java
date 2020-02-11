package com.mikhailovskii.lab2;

public class Faculty {

    private String name;
    private int size;
    private int payment;

    Faculty(String name, int size, int payment) {
        this.name = name;
        this.size = size;
        this.payment = payment;
    }

    String getName() {
        return name;
    }

    int getSize() {
        return size;
    }

    int getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return name + " " + size + " " + payment;
    }
}
