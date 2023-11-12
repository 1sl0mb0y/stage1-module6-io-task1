package com.epam.mjc.io;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public static Profile getDataFromFile(File file) {
        try {
            Map<String, String> profileMap = new HashMap<>();
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file.getName()));
            String line;
            while ((line = reader.readLine()) != null) {
                profileMap.put(line.split(" ")[0], line.split(" ")[1]);
            }
            Profile profile = new Profile();
            profile.setName(profileMap.get("Name:"));
            profile.setAge(Integer.valueOf(profileMap.get("Age:")));
            profile.setEmail(profileMap.get("Email:"));
            profile.setPhone(Long.valueOf(profileMap.get("Phone:")));

            return profile;
        } catch (IOException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }
}
