package com.genesisresources.GenesisResourcesRegistry.controller;

import com.genesisresources.GenesisResourcesRegistry.dto.*;
import com.genesisresources.GenesisResourcesRegistry.model.UserModel;
import com.genesisresources.GenesisResourcesRegistry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public void createUser(@RequestBody CreateUserDTO createdUserDTO) {
        if(!userService.usedIDlist().contains(createdUserDTO.getPersonID()) &&
            userService.importedIDs().contains(createdUserDTO.getPersonID())) {
            userService.createUser(createdUserDTO);
        }
    }

    @GetMapping("/{ID}")
    public GetUserDTO getUserById(@PathVariable Long iD, @RequestParam(required = false) boolean detail) {
        UserModel user = userService.getUserInfo(iD);
        if(detail) {
            return new GetUserFullDTO(user);
        } else {
            return new GetUserBasicDTO(user);
        }
    }

    @GetMapping()
    public List<?> getAllUsers(@RequestParam(required = false) boolean detail) {
        if (detail) {
            return new ArrayList<>(userService.listToFullDTO());
        } else {
            return new ArrayList<>(userService.listToBasicDTO());
        }
    }

    @PutMapping()
    public void updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        userService.updateUser(updateUserDTO,updateUserDTO.getiD());
    }

    @DeleteMapping("/{ID}")
    public void deleteUser(@PathVariable Long iD) {
        userService.deleteUser(iD);
    }
}
