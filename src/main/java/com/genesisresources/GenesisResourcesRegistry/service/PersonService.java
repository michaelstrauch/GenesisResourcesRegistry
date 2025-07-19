package com.genesisresources.GenesisResourcesRegistry.service;

import com.genesisresources.GenesisResourcesRegistry.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    @Autowired
    PersonModel userModel;

    List<PersonModel> userList = new ArrayList<>();

    public void addUser(PersonModel userModel) {
        userList.add(userModel);
    }

    public PersonModel getUserInfo(Long iD) {
        PersonModel foundUser = null;
        for (PersonModel model : userList) {
            if(model.getID().equals(iD)) {
                foundUser = model;

            }
        } return foundUser;
    }

    public List<PersonModel> getAllUsers() {
        return userList;
    }

    public void updateUser(Long iD) {

    }
}
