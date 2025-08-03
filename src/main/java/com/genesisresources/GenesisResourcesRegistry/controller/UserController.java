package com.genesisresources.GenesisResourcesRegistry.controller;

import com.genesisresources.GenesisResourcesRegistry.dto.*;
import com.genesisresources.GenesisResourcesRegistry.model.UserModel;
import com.genesisresources.GenesisResourcesRegistry.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public GetUserFullDTO createUser(@RequestBody CreateUserDTO createdUserDTO) {
        UserModel user = userService.createUser(createdUserDTO);
        return new GetUserFullDTO(user);
    }

    @GetMapping("/{iD}")
    public GetUserBasicDTO getUserById(@PathVariable Long iD, @RequestParam(required = false) boolean detail) {
        UserModel user = userService.getUserInfo(iD);
        if (detail) {
            return new GetUserFullDTO(user);
        } else {
            return new GetUserBasicDTO(user);
        }
    }

    @GetMapping()
    public List<GetUserBasicDTO> getAllUsers(@RequestParam(required = false) boolean detail) {
        if (detail) {
            return new ArrayList<>(listToFullDTO());
        } else {
            return new ArrayList<>(listToBasicDTO());
        }
    }

    @PutMapping()
    public void updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        userService.updateUser(updateUserDTO, updateUserDTO.getiD());
    }

    @DeleteMapping("/{iD}")
    public void deleteUser(@PathVariable Long iD) {
        userService.deleteUser(iD);
    }

    public List<GetUserBasicDTO> listToBasicDTO() {
        List<UserModel> originList = userService.getAllUsers();
        List<GetUserBasicDTO> DTOList = new ArrayList<>();
        for (UserModel userModel : originList) {
            DTOList.add(new GetUserBasicDTO(userModel));
        }
        return DTOList;
    }

    public List<GetUserFullDTO> listToFullDTO() {
        List<UserModel> originList = userService.getAllUsers();
        List<GetUserFullDTO> DTOList = new ArrayList<>();
        for (UserModel userModel : originList) {
            DTOList.add(new GetUserFullDTO(userModel));
        }
        return DTOList;
    }
}
