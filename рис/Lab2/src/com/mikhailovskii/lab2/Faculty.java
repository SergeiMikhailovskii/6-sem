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

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return name + " " + size + " " + payment;
    }
}
