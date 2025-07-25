package com.genesisresources.GenesisResourcesRegistry.service;

import com.genesisresources.GenesisResourcesRegistry.dto.CreateUserDTO;
import com.genesisresources.GenesisResourcesRegistry.dto.GetUserDTO;
import com.genesisresources.GenesisResourcesRegistry.model.UserModel;
import com.genesisresources.GenesisResourcesRegistry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public GetUserDTO getFullUserInfo(Long id) {
        String query = "select * from users where id= ?";
       GetUserDTO user = jdbcTemplate.queryForObject(query, new RowMapper<GetUserDTO>() {
           @Override
           public GetUserDTO mapRow(ResultSet result, int rowNum) throws SQLException {
               GetUserDTO foundUser = new GetUserDTO();
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

    public GetUserDTO getUserBasicInfo(Long id) {
        String query = "select * from users where id= ?";
        GetUserDTO user = jdbcTemplate.queryForObject(query, new RowMapper<GetUserDTO>() {
            @Override
            public GetUserDTO mapRow(ResultSet result, int rowNum) throws SQLException {
                GetUserDTO foundUser = new GetUserDTO();
                foundUser.setiD(result.getLong("ID"));
                foundUser.setName(result.getString("Name"));
                foundUser.setSurname(result.getString("Surname"));
                return foundUser;
            }
        }
        ,id);
        return user;
    }

    public List<String> usedIDlist() {
        List<String> usedID = jdbcTemplate.query("select PersonID from users",
                (result, rowNum) -> result.getString("PersonID"));
        return usedID;
    }

//    public String uniqueIDSelector() {
//        List<String> usedIdlist = usedIDlist();
//        for (String iD : iDimport.getPersonIDListCopy()) {
//            if(!usedIdlist.contains(iD)) {
//                return iD;
//            }
//        }
//        return null;
//    }
}


