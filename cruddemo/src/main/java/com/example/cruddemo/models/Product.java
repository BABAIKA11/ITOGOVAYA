package com.example.cruddemo.models;

import javax.persistence.*;

@Entity
@Table(name = "product")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String description;
    private String amount;
    private String color;
    private String amountofitems;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Manufacturer manufacturer;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Storage storage;

    public Product() {}

    public Product(String name, int price, String description, String amount, String color, String amountofitems, Manufacturer manufacturer, Storage storage) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
        this.color = color;
        this.amountofitems = amountofitems;
        this.manufacturer = manufacturer;
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAmountofitems() {
        return amountofitems;
    }

    public void setAmountofitems(String amountofitems) {
        this.amountofitems = amountofitems;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
