package com.example.cruddemo.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "passport")

public class Passport {

    @Id
    private int id;
    private String series;
    private String number;
    private String issuedbywhom;
    private Date dateofissue;

    @OneToOne(optional = true, mappedBy = "passport")
    private Employee owner;

    public Passport() {}
    public Passport(String series, String number, String issuedbywhom, Date dateofissue, Employee owner) {
        this.series = series;
        this.number = number;
        this.issuedbywhom = issuedbywhom;
        this.dateofissue = dateofissue;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssuedbywhom() {
        return issuedbywhom;
    }

    public void setIssuedbywhom(String issued_by_whom) {
        this.issuedbywhom = issued_by_whom;
    }

    public Date getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(Date date_of_issue) {
        this.dateofissue = date_of_issue;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }
}
