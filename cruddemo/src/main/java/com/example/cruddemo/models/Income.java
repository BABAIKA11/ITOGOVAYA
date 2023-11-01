package com.example.cruddemo.models;

import javax.persistence.*;

@Entity
@Table(name = "income")

public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String day;

    private String month;
    private String year;
    private int incomerubles;

    public Income() {}

    public Income(String day, String month, String year, int incomerubles) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.incomerubles = incomerubles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getIncomerubles() {
        return incomerubles;
    }

    public void setIncomerubles(int incomerubles) {
        this.incomerubles = incomerubles;
    }
}
