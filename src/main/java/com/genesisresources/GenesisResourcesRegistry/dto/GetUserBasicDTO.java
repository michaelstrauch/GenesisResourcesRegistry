package com.genesisresources.GenesisResourcesRegistry.dto;

import com.genesisresources.GenesisResourcesRegistry.model.UserModel;

public class GetUserBasicDTO {

    private Long iD;
    private String name;
    private String surname;


    public GetUserBasicDTO(UserModel userModel) {
        this.iD = userModel.getID();
        this.name = userModel.getName();
        this.surname = userModel.getSurname();
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

}
