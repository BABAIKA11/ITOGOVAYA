package com.example.cruddemo.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "manufacturer")

public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany (mappedBy = "manufacturer", fetch = FetchType.EAGER)
    private Collection<Product> prod;


    public Manufacturer() {}

    public Manufacturer(String name, Collection<Product> prod) {
        this.name = name;
        this.prod = prod;
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

    public Collection<Product> getProd() {
        return prod;
    }

    public void setProd(Collection<Product> prod) {
        this.prod = prod;
    }
}
