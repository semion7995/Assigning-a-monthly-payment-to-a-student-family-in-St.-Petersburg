package edu.javacource.studentorder.domain;

import java.time.LocalDate;

public abstract class Person {

    private String surName;
    private String givenName;
    private String patronymic;//отчество
    private LocalDate dateOfBirth;
    private Address address;

    public Person(String surName, String givenName, String patronymic, LocalDate dateOfBirth) {
        this.surName = surName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }
    public Person(){

    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surName='" + surName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", postcode=" + address.getStreet().getStreetCode() +
                ", building=" + address.getBuilding() +
                ", extension=" + address.getExtension() +
                ", apartment=" + address.getApartment() +
                '}';
    }
}
