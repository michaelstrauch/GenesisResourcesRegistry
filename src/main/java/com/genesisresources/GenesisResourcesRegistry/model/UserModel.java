package com.genesisresources.GenesisResourcesRegistry.model;

public class UserModel {

    Long ID;
    String Name;
    String Surname;
    String PersonID;
    String Uuid;

    public UserModel(Long ID, String name, String surname, String personID, String uuid) {
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
