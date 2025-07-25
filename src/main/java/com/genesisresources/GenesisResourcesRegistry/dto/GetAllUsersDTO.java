package com.genesisresources.GenesisResourcesRegistry.dto;

public class GetAllUsersDTO {

    private Long iD;
    private String name;
    private String surname;

    public GetAllUsersDTO(Long iD, String name, String surname) {
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
}
