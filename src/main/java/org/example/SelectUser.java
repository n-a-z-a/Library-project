package org.example;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SelectUser {
    private Scanner scanner = new Scanner(System.in);
    Gson gson = new Gson();


    public User selectUser() throws IOException {
        System.out.println("Please select from the options below:");
        System.out.println("U - User");
        System.out.println("A - Admin");
        User user = new User(null, null);
        while (true) {
            String input = scanner.nextLine().replace(" ", "").toUpperCase();
            if (!input.equals("U") && !input.equals("A")) {
                System.out.println("Please select between U and A:");
            } else if (input.equals("U")) {
                System.out.println("Please select between the following options:");
                System.out.println("1 - New User");
                System.out.println("2 - Recurring User");
                String userInput = scanner.nextLine().replace(" ", "").toUpperCase();
                if (!userInput.equals("1") && !userInput.equals("2")) {
                    System.out.println("Please select between 1 and 2:");
                    System.out.println(userInput);
                } else if (userInput.equals("1")) {
                    System.out.println("Please enter your name:");
                    String userName = scanner.nextLine().replace(" ", "").toUpperCase();
                    System.out.println("Please enter a password:");
                    String userPassword = scanner.nextLine().replace(" ", "").toUpperCase();
                    user = new User(userName, userPassword);
                    gson.toJson(user, new FileWriter("src/main/java/org/example/user_data.json"));
                    break;
                } else if (userInput.equals("2")) {
                    System.out.println("Please enter your name:");
                    String userName = scanner.nextLine().replace(" ", "").toUpperCase();



                }
            } else if (input.equals("A")) {
                System.out.println("Please enter your admin password:");
                String adminPassword = scanner.nextLine().replace(" ", "").toUpperCase();
                while (true) {
                    if (adminPassword.equals("ADMIN")) {
                        System.out.println("Login successful!");
                        user = new User("admin", "admin");
                        break;
                    } else {
                        System.out.println("Incorrect password! Try again:");
                        adminPassword = scanner.nextLine().replace(" ", "").toUpperCase();
                    }
                }
                break;
            }
        }
        return user;
    }
}
