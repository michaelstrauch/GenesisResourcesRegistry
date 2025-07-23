package com.genesisresources.GenesisResourcesRegistry.service;

import com.genesisresources.GenesisResourcesRegistry.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PersonIDImporter iDimport;

    public void createUser(PersonModel personModel) {
        String query = "insert into Persons (name, surname, personID) values(?,?,?)";
        jdbcTemplate.update(query, personModel.getName(),personModel.getSurname(), uniqueIDSelector());
    }

    public List<String> usedIDlist() {
        List<String> usedID = jdbcTemplate.query("select PersonID from persons",
                (result, rowNum) -> result.getString("PersonID"));
        return usedID;
    }

    public String uniqueIDSelector() {
        for (String iD : iDimport.getPersonIDListCopy()) {
            if(!usedIDlist().contains(iD)) {
                return iD;
            }
        }
        return null;
    }
}


