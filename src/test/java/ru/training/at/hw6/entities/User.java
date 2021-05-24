package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {

    public static final User ROMAN = new User("Roman", "Jdi1234");

    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }




}
