package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "surname is required")
    private String surname;
    @NotNull(message = "firstname is required")
    private String firstname;
    @NotNull(message = "midname is required")
    private String midname;
    @NotNull(message = "workexperience is required")
    private int workexperience;
    @NotNull(message = "phonenumber is required")
    private String phonenumber;
    @NotNull(message = "mail is required")
    private String mail;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Passport passport;

    @ManyToMany
    @JoinTable (name="compliance",
            joinColumns=@JoinColumn (name="employeeid"),
            inverseJoinColumns=@JoinColumn(name="roleid"))
    private List<Role> roles;

    public Employee() {
    }

    public Employee(String surname, String firstname, String midname, int workexperience, String phonenumber, String mail, Passport passport, List<Role> roles) {
        this.surname = surname;
        this.firstname = firstname;
        this.midname = midname;
        this.workexperience = workexperience;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.passport = passport;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public int getWorkexperience() {
        return workexperience;
    }

    public void setWorkexperience(int workexperience) {
        this.workexperience = workexperience;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
