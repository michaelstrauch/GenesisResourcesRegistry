package com.genesisresources.GenesisResourcesRegistry.service;

import com.genesisresources.GenesisResourcesRegistry.dto.*;
import com.genesisresources.GenesisResourcesRegistry.exception.UserNotFoundException;
import com.genesisresources.GenesisResourcesRegistry.exception.WrongPersonIdException;
import com.genesisresources.GenesisResourcesRegistry.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PersonIDImporter iDimport;


    public void createUser(CreateUserDTO dtoUser) {
        if(!usedIDlist().contains(dtoUser.getPersonID()) &&
                importedIDs().contains(dtoUser.getPersonID())) {
            String query = "insert into users (Name, Surname, PersonID, Uuid) values(?,?,?,?)";
            String uuid = String.valueOf(UUID.randomUUID());
            jdbcTemplate.update(query, dtoUser.getName(), dtoUser.getSurname(), dtoUser.getPersonID(), uuid);
        } else {
            throw new WrongPersonIdException("PersonID doesn't exist or is already in use");
        }
    }

    public UserModel getUserInfo(Long iD) {
        String query = "select * from users where id= ?";
        try {
            UserModel user = jdbcTemplate.queryForObject(query, new RowMapper<UserModel>() {
                        @Override
                        public UserModel mapRow(ResultSet result, int rowNum) throws SQLException {
                            UserModel foundUser = new UserModel();
                            foundUser.setiD(result.getLong("ID"));
                            foundUser.setName(result.getString("Name"));
                            foundUser.setSurname(result.getString("Surname"));
                            foundUser.setPersonID(result.getString("PersonID"));
                            foundUser.setUuid(result.getString("Uuid"));
                            return foundUser;
                        }
                    }
                    , iD);
            return user;
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException("User with Id: "+ iD + " not found");
        }
    }

    public List<UserModel> getAllUsers() {
        String query = "select * from users";
        List<UserModel> userList = jdbcTemplate.query(query, new RowMapper<UserModel>() {
            @Override
            public UserModel mapRow(ResultSet result, int rowNum) throws SQLException {
                UserModel foundUser = new UserModel();
                foundUser.setiD(result.getLong("ID"));
                foundUser.setName(result.getString("Name"));
                foundUser.setSurname(result.getString("Surname"));
                foundUser.setPersonID(result.getString("PersonID"));
                foundUser.setUuid(result.getString("Uuid"));
                return foundUser;
            }
        });
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No users found");
        } else {
            return userList;
        }
    }

    public List<GetUserBasicDTO> listToBasicDTO() {
        List<UserModel> originList = getAllUsers();
        List<GetUserBasicDTO> DTOList = new ArrayList<>();
        for (UserModel userModel : originList) {
            DTOList.add(new GetUserBasicDTO(userModel));
        }
        return DTOList;
    }

    public List<GetUserFullDTO> listToFullDTO() {
        List<UserModel> originList = getAllUsers();
        List<GetUserFullDTO> DTOList = new ArrayList<>();
        for (UserModel userModel : originList) {
            DTOList.add(new GetUserFullDTO(userModel));
        }
        return DTOList;
    }

    public void updateUser(UpdateUserDTO updateUserDTO, Long iD) {
        String query = "update users set name=?,surname=? where id=?";
        int rowsAffected = jdbcTemplate.update(query, updateUserDTO.getName(), updateUserDTO.getSurname(), iD);
        if (rowsAffected == 0) {
            throw new UserNotFoundException("User with Id: "+ iD + " not found");
        }
    }

    public void deleteUser(Long iD) {
        String query = "delete from users where id=?";
        String afterQuery = "alter table users auto_increment=?";
        int rowsAffected = jdbcTemplate.update(query, iD);
        jdbcTemplate.update(afterQuery,iD);
        if(rowsAffected == 0) {
            throw new UserNotFoundException("User with Id: " + iD + " not found");
        }
    }

    public List<String> usedIDlist() {
        List<String> usedID = jdbcTemplate.query("select PersonID from users",
                (result, rowNum) -> result.getString("PersonID"));
        return usedID;
    }


    public List<String> importedIDs() {
        return iDimport.getPersonIDListCopy();
    }
}



