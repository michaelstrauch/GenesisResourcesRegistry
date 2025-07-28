package com.genesisresources.GenesisResourcesRegistry.dto;

import com.genesisresources.GenesisResourcesRegistry.model.UserModel;

public class GetUserFullDTO implements GetUserDTO {

    private Long iD;
    private String name;
    private String surname;
    private String personID;
    private String uuid;

    public GetUserFullDTO() {
    }

    public GetUserFullDTO(UserModel userModel) {
        this.iD = userModel.getID();
        this.name = userModel.getName();
        this.surname = userModel.getSurname();
        this.personID = userModel.getPersonID();
        this.uuid = userModel.getUuid();
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
