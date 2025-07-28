package com.genesisresources.GenesisResourcesRegistry.dto;

import com.genesisresources.GenesisResourcesRegistry.model.UserModel;

public class GetUserBasicDTO implements GetUserDTO {

    private Long iD;
    private String name;
    private String surname;

    public GetUserBasicDTO() {
    }

    public GetUserBasicDTO(UserModel userModel) {
        this.iD = userModel.getID();
        this.name = userModel.getName();
        this.surname = userModel.getSurname();
    }

    public Long getiD() {
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
}
