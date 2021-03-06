package com.mikhailovskii.lab8.entity;

import com.mikhailovskii.lab8.adapter.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Citizenship.class, City.class})
public class PersonResponse implements Serializable {

    private int id;
    private String surname;
    private String name;
    private String lastName;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateOfBirth;
    private String passwordSeries;
    private City city;
    private String addressFact;
    private String phoneNumber;
    private String email;
    private boolean isEmployed;
    private String position;
    private String addressRegistration;
    private Citizenship citizenship;

    public PersonResponse(int id, String surname, String name, String lastName, Date dateOfBirth, String passwordSeries, City city, String addressFact, String phoneNumber, String email, boolean isEmployed, String position, String addressRegistration, Citizenship citizenship) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.passwordSeries = passwordSeries;
        this.city = city;
        this.addressFact = addressFact;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isEmployed = isEmployed;
        this.position = position;
        this.addressRegistration = addressRegistration;
        this.citizenship = citizenship;
    }

    public PersonResponse(Person person) {
        this.id = person.getId();
        this.surname = person.getSurname();
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.dateOfBirth = person.getDateOfBirth();
        this.passwordSeries = person.getPasswordSeries();
        this.addressFact = person.getAddressFact();
        this.phoneNumber = person.getPhoneNumber();
        this.email = person.getEmail();
        this.isEmployed = person.isEmployed();
        this.position = person.getPosition();
        this.addressRegistration = person.getAddressRegistration();
    }

    public PersonResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPasswordSeries() {
        return passwordSeries;
    }

    public void setPasswordSeries(String passwordSeries) {
        this.passwordSeries = passwordSeries;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddressFact() {
        return addressFact;
    }

    public void setAddressFact(String addressFact) {
        this.addressFact = addressFact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddressRegistration() {
        return addressRegistration;
    }

    public void setAddressRegistration(String addressRegistration) {
        this.addressRegistration = addressRegistration;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

}
