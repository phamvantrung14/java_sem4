package com.example.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private String country;

    public User() {
    }

    public User( String name, String password, String country) {

        this.name = name;
        this.password = password;
        this.country = country;
    }

    public User(int id, String name, String password, String country) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
