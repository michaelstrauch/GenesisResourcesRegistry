package com.genesisresources.GenesisResourcesRegistry.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class PersonIDImporter {
    private String filepath = "personIdData.txt";
    private List<String> personIDlist = new ArrayList<>();


    public void idImport() throws FileNotFoundException {
        Scanner reader = new Scanner(new BufferedReader(new FileReader(filepath)));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            personIDlist.add(line);
        }
    }

    public List<String> getPersonIDListCopy() {
        return new ArrayList<>(personIDlist);
    }
}
