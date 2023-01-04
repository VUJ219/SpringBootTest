package com.vuj.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;


//INSERT INTO USERTABLE(username, emailAddress, Password)
//VALUES('Janos10','janos@gmail.com','af34awresfdy'),
//      ('_Bela_','bela@gmail.com','be14ak1r41y');
@Entity(name = "USERTABLE")
public class User {
    @Id
    @GeneratedValue
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
