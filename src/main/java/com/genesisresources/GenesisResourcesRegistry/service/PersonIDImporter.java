package com.genesisresources.GenesisResourcesRegistry.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class PersonIDImporter {
    private List<String> personIDlist = new ArrayList<>();

    @PostConstruct
    public void idImport() {
        InputStream inputFile = getClass().getClassLoader().getResourceAsStream("personIdData.txt");
        if (inputFile != null) {
        Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(inputFile)));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            personIDlist.add(line);}
        } else {
            throw new RuntimeException();
        }
    }

    public List<String> getPersonIDListCopy() {
        return new ArrayList<>(personIDlist);
    }
}
