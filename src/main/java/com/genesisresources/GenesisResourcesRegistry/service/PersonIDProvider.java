package com.genesisresources.GenesisResourcesRegistry.service;

import com.genesisresources.GenesisResourcesRegistry.exception.FatalException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class PersonIDProvider {
    private List<String> personIDlist = new ArrayList<>();

    @PostConstruct
    public void idImport() {
        try (InputStream inputFile = getClass().getClassLoader().getResourceAsStream("personIdData.txt")) {
            if (inputFile != null) {
                Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(inputFile)));
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    personIDlist.add(line);
                }
            }
        } catch (IOException ex) {
            throw new FatalException("Failed to load PersonID from file: " + ex.getMessage());
        }
    }

    public List<String> getPersonIDList() {
        return new ArrayList<>(personIDlist);
    }
}
