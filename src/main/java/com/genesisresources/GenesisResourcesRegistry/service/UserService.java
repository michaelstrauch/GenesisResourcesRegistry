package com.genesisresources.GenesisResourcesRegistry.service;

import com.genesisresources.GenesisResourcesRegistry.dto.CreateUserDTO;
import com.genesisresources.GenesisResourcesRegistry.dto.GetUserBasicDTO;
import com.genesisresources.GenesisResourcesRegistry.dto.GetUserDTO;
import com.genesisresources.GenesisResourcesRegistry.dto.GetUserFullDTO;
import com.genesisresources.GenesisResourcesRegistry.model.UserModel;
import com.genesisresources.GenesisResourcesRegistry.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserRepository userRepository;

    @Autowired
    PersonIDImporter iDimport;


    public void createUser(CreateUserDTO dtoUser) {
        String uuid = String.valueOf(UUID.randomUUID());
        UserModel newUser = new UserModel();
        newUser.setName(dtoUser.getName());
        newUser.setSurname(dtoUser.getSurname());
        newUser.setPersonID(dtoUser.getPersonID());
        newUser.setUuid(uuid);
        userRepository.save(newUser);
    }

    public UserModel getUserInfo(Long id) {
        String query = "select * from users where id= ?";
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
       ,id);
       return user;
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
        return userList;
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




//    public GetBasicUserDTO getBasicUserInfo(Long id) {
//        String query = "select * from users where id= ?";
//        GetBasicUserDTO user = jdbcTemplate.queryForObject(query, new RowMapper<GetBasicUserDTO>() {
//            @Override
//            public GetBasicUserDTO mapRow(ResultSet result, int rowNum) throws SQLException {
//                GetBasicUserDTO foundUser = new GetBasicUserDTO();
//                foundUser.setiD(result.getLong("ID"));
//                foundUser.setName(result.getString("Name"));
//                foundUser.setSurname(result.getString("Surname"));
//                return foundUser;
//            }
//        }
//        ,id);
//        return user;
//    }

    public List<String> usedIDlist() {
        List<String> usedID = jdbcTemplate.query("select PersonID from users",
                (result, rowNum) -> result.getString("PersonID"));
        return usedID;
    }


    public List<String> importedIDs() {
        return iDimport.getPersonIDListCopy();
    }
}


