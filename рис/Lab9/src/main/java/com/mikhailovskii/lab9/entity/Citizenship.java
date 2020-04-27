package com.mikhailovskii.lab9.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "citizenship")
public class Citizenship implements Serializable {

    @Id
    private int id;
    private String name;

    public Citizenship(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Citizenship() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
