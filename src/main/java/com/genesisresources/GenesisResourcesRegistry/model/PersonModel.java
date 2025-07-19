package com.genesisresources.GenesisResourcesRegistry.model;


import jakarta.persistence.*;


@Entity
@Table(name = "Persons")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long ID;

    @Column(nullable = false)
    private String Name;

    @Column
    private String Surname;

    @Column(nullable = false, unique = true)
    private String PersonID;

    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Uuid;

    public PersonModel(Long ID, String name, String surname, String personID, String uuid) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        PersonID = personID;
        Uuid = uuid;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }
}
