package com.example.qualifandro.model;
import java.io.Serializable;

public class User implements Serializable {

    private String fullName, email, password, gender;

    public User(){

    }
    public User(String fullName, String email, String password, String gender) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}