package com.example.cruddemo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "role")

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String namerole;
    private int salary;
    @ManyToMany
    @JoinTable (name="combination",
            joinColumns=@JoinColumn (name="roleid"),
            inverseJoinColumns=@JoinColumn(name="employeeid"))
    private List<Employee> employees;

    public Role() {}

    public Role(String namerole, int salary, List<Employee> employees) {
        this.namerole = namerole;
        this.salary = salary;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamerole() {
        return namerole;
    }

    public void setNamerole(String namerole) {
        this.namerole = namerole;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
