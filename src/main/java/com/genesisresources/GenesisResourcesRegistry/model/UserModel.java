package com.genesisresources.GenesisResourcesRegistry.model;



public class UserModel {

    private Long iD;
    private String name;
    private String surname;
    private String personID;
    private String uuid;

    public UserModel() {
    }

    public UserModel(Long iD, String name, String surname, String personID, String uuid) {
        this.iD = iD;
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
