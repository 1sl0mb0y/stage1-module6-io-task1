package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(file.getPath()))) {
            Map<String, String> profileMap = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitedString = line.split(" ");
                profileMap.put(splitedString[0], splitedString[1]);
            }
            return toProfile(profileMap);
        } catch (IOException e) {
           e.printStackTrace();
        }

        return null;
    }

    private Profile toProfile(Map<String, String> profileMap) {
        Profile profile = new Profile();
        profile.setName(profileMap.get("Name:"));
        profile.setAge(Integer.valueOf(profileMap.get("Age:")));
        profile.setEmail(profileMap.get("Email:"));
        profile.setPhone(Long.valueOf(profileMap.get("Phone:")));
        return profile;
    }
}
