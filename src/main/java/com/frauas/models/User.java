package com.frauas.models;

public class User {
    private static User user = null;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }

        return user;
    }
}
