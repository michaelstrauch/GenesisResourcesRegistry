package com.genesisresources.GenesisResourcesRegistry.model;


import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "Persons")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long ID;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column(nullable = false, unique = true)
    private String personID;

    @Column(nullable = false, unique = true)
    private String uuid;

    public PersonModel(String name, String surname, String personID) {
        this.name = name;
        this.surname = surname;
        this.personID = personID;
        setUuid();

    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }
}
