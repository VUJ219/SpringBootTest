package com.vuj.practice.model.dto;

public class UserDto {
    private Integer id;
    private String Username;
    private String EmailAddress;
    private String Password;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
