package com.genesisresources.GenesisResourcesRegistry.model;


import jakarta.persistence.*;



@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long iD;

    @Column(nullable = false)
    private String name;

    @Column
    private String surname;

    @Column(nullable = false, unique = true)
    private String personID;

    @Column(nullable = false, unique = true)
    private String uuid;


    public UserModel() {
    }

    public UserModel(String name, String surname, String personID, String uuid) {
        this.name = name;
        this.surname = surname;
        this.personID = personID;
        this.uuid = uuid;

    }

    public Long getID() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
