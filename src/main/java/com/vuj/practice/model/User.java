package com.vuj.practice.model;

import javax.persistence.*;


@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String emailAddress;
    private String password;
    @Lob
    byte[] profilePicture;

    public User() {
        id = 0;
        username = "";
        emailAddress = "";
        password = "";
        profilePicture = null;
    }

    public User(String username, String emailAddress, String password) {
        id = 0;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        profilePicture = null;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
