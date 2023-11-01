package com.example.cruddemo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "storage")

public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String number;

    @OneToMany (mappedBy = "storage", fetch = FetchType.EAGER)
    private Collection<Product> prod;

    public Storage() {}
    public Storage(String number, Collection<Product> prod) {
        this.number = number;
        this.prod = prod;
    }

    public Collection<Product> getProd() {
        return prod;
    }

    public void setProd(Collection<Product> prod) {
        this.prod = prod;
    }

    public Storage(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
