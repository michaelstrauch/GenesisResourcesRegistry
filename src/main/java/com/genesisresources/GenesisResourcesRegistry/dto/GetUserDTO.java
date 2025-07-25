package com.genesisresources.GenesisResourcesRegistry.dto;

public class GetUserDTO {

    private Long iD;
    private String name;
    private String surname;
    private String personID;
    private String uuid;

    public GetUserDTO() {
    }

    public GetUserDTO(Long iD, String name, String surname, String personID, String uuid) {
        this.iD = iD;
        this.name = name;
        this.surname = surname;
        this.personID = personID;
        this.uuid = uuid;
    }

    public GetUserDTO(Long iD, String name, String surname) {
        this.iD = iD;
        this.name = name;
        this.surname = surname;
    }

    public Long getiD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonID() {
        return personID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
