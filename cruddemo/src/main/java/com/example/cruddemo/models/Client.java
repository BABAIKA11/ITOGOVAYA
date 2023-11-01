package com.example.cruddemo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String mail;


    private String salt;


    private String hash;


    public Client() {}

    public Client(String mail, String salt, String hash) {
        this.mail = mail;
        this.salt = salt;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
