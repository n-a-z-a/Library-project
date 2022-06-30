package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class User {

    private String name, password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getUsersFromJSON() {

        List<User> users = null;
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/org/example/user_data.json"));

            // convert JSON array to list of users
            users = new Gson().fromJson(reader, new TypeToken<List<User>>() {
            }.getType());

            // print users
            users.forEach(System.out::println);

            // close reader
            reader.close();

            return users;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return users;
    }
}
