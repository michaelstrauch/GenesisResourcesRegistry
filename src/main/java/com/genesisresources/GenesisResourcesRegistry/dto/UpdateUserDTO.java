package com.genesisresources.GenesisResourcesRegistry.dto;

public class UpdateUserDTO {

    private Long iD;
    private String name;
    private String surname;

    public UpdateUserDTO(String name, String surname, Long iD) {
        this.name = name;
        this.surname = surname;
        this.iD = iD;
    }

    public Long getiD() {
        return iD;
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
