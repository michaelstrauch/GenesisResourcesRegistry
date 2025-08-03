package com.genesisresources.GenesisResourcesRegistry.dto;

import com.genesisresources.GenesisResourcesRegistry.model.UserModel;

public class GetUserFullDTO extends GetUserBasicDTO {


    private String personID;
    private String uuid;

//    public GetUserFullDTO() {
//    }

    public GetUserFullDTO(UserModel userModel) {
        super(userModel);
        this.personID = userModel.getPersonID();
        this.uuid = userModel.getUuid();
    }

    public String getPersonID() {
        return personID;
    }

    public String getUuid() {
        return uuid;
    }

}
